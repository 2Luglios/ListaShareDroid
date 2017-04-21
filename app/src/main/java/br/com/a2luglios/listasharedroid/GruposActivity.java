package br.com.a2luglios.listasharedroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    }
}
