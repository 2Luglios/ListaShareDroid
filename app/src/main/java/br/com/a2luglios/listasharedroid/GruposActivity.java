package br.com.a2luglios.listasharedroid;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.a2luglios.listasharedroid.adapters.ListaListasAdapter;

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

        LinearLayout listaGrupos = (LinearLayout)findViewById(R.id.listaGrupoInterna);
        TextView tv = new TextView(this);
        tv.setText("Texto");
        tv.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        TextView tv2 = new TextView(this);
        tv2.setText("Texto");
        tv2.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        listaGrupos.addView(tv, 0);
        listaGrupos.addView(tv2, 0);

    }
}
