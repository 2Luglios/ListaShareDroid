package br.com.a2luglios.listasharedroid;

import android.content.Intent;
import android.net.Uri;
import android.opengl.ETC1;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.File;

public class CadastroProdutosActivity extends AppCompatActivity {

    private static final int TIRAR_FOTO = 101;

    private EditText nome;
    private EditText marca;
    private EditText opcional;
    private EditText obs;
    private TextView quantidade;

    private int qtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_produtos_activity_layout);

        nome = (EditText) findViewById(R.id.campoNome);
        marca = (EditText) findViewById(R.id.campoMarca);
        opcional = (EditText) findViewById(R.id.campoOpcional);
        obs = (EditText) findViewById(R.id.campoObs);
        quantidade = (TextView) findViewById(R.id.quantidade);

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
//                File f = new File(Environment.getExternalStoragePublicDirectory(null), System.currentTimeMillis() + ".jpg");
//                Uri file = Uri.fromFile(f);
//                intentTiraFoto.putExtra(MediaStore.EXTRA_OUTPUT, file);

                startActivityForResult(intentTiraFoto, TIRAR_FOTO);
            }
        });

        Button btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                // TODO Salvar a foto no lugar certo!
            }
        }
    }
}
