package br.com.a2luglios.listasharedroid;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import br.com.a2luglios.listasharedroid.adapters.ListaListasAdapter;
import br.com.a2luglios.listasharedroid.dao.CompartilhamentoDao;
import br.com.a2luglios.listasharedroid.modelo.Compartilhamento;
import br.com.a2luglios.listasharedroid.util.BitmapUtil;

public class GruposActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grupos_activity_layout);

        Button btnMinhasListas = (Button) findViewById(R.id.btnMinhasListas);
        btnMinhasListas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GruposActivity.this, ListaListViewActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        recarregaLista();
    }

    public void recarregaLista() {
        LinearLayout listaGrupos = (LinearLayout)findViewById(R.id.listaGrupoInterna);

        CompartilhamentoDao dao = new CompartilhamentoDao(this);
        List<Compartilhamento> lista = dao.lista();
        dao.close();

        for (Compartilhamento c : lista) {
            View v = LayoutInflater.from(this).inflate(R.layout.item_grupo_layout, null);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("GA", "Clicou aqui...");
                }
            });

            ImageView imagem = (ImageView) v.findViewById(R.id.imagem);
            TextView nome = (TextView) v.findViewById(R.id.nome);

            imagem.setImageBitmap(BitmapUtil.getImage(c.getImagem()));
            nome.setText(c.getNome());

            listaGrupos.addView(v);
        }

    }
}
