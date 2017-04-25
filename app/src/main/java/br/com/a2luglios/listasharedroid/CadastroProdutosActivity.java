package br.com.a2luglios.listasharedroid;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import br.com.a2luglios.listasharedroid.dao.ProdutoDao;
import br.com.a2luglios.listasharedroid.modelo.Produto;
import br.com.a2luglios.listasharedroid.util.BitmapUtil;

public class CadastroProdutosActivity extends AppCompatActivity {

    private static final int TIRAR_FOTO = 101;
    private String nomeArquivoFoto;

    private EditText nome;
    private EditText marca;
    private EditText opcional;
    private EditText obs;
    private TextView quantidade;
    private ImageView imagem;

    private Long idLista;

    private int qtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_produtos_activity_layout);

        idLista = getIntent().getLongExtra("idLista", 0);

        nome = (EditText) findViewById(R.id.campoNome);
        marca = (EditText) findViewById(R.id.campoMarca);
        opcional = (EditText) findViewById(R.id.campoOpcional);
        obs = (EditText) findViewById(R.id.campoObs);
        quantidade = (TextView) findViewById(R.id.quantidade);
        imagem = (ImageView) findViewById(R.id.imagem);

        quantidade.setText("" + qtd);

        Button btnMaisQuantidade = (Button) findViewById(R.id.btnMaisQtd);
        btnMaisQuantidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qtd++;
                quantidade.setText("" + qtd);
            }
        });

        Button btnMenosQuantidade = (Button) findViewById(R.id.btnMenosQtd);
        btnMenosQuantidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qtd--;
                if ( qtd < 0 ) qtd = 0;

                quantidade.setText("" + qtd);
            }
        });

        ImageButton btnTiraFoto = (ImageButton) findViewById(R.id.imagem);
        btnTiraFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTiraFoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                nomeArquivoFoto = Environment.getExternalStoragePublicDirectory(null) + "/" + System.currentTimeMillis() + ".jpg";
                File f = new File(nomeArquivoFoto);
                Uri file = Uri.fromFile(f);
                intentTiraFoto.putExtra(MediaStore.EXTRA_OUTPUT, file);

                startActivityForResult(intentTiraFoto, TIRAR_FOTO);
            }
        });

        Button btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Produto produto = new Produto();
                produto.setNome(nome.getEditableText().toString());
                produto.setObs(obs.getEditableText().toString());
                produto.setChecado(false);
                produto.setMarca(marca.getEditableText().toString());
                produto.setOpcional(opcional.getEditableText().toString());
                //produto.setImagem(BitmapUtil.getBytes(imagem.getDrawingCache()));
                produto.setQuantidade(qtd);
                produto.setIdLista(idLista);

                ProdutoDao dao = new ProdutoDao(CadastroProdutosActivity.this);
                dao.insertOrUpdate(produto);
                dao.close();

                finish();
            }
        });

        Button btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ( requestCode == TIRAR_FOTO ) {
            if ( resultCode == RESULT_OK ) {
                imagem.setImageBitmap(BitmapFactory.decodeFile(nomeArquivoFoto));
            }
        }
    }
}
