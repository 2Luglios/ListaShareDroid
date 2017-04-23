package br.com.a2luglios.listasharedroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import br.com.a2luglios.listasharedroid.adapters.ListaListasAdapter;
import br.com.a2luglios.listasharedroid.dao.ListaDao;
import br.com.a2luglios.listasharedroid.modelo.Lista;

public class ListaListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_activity_layout);

        ListView listaListas = (ListView) findViewById(R.id.listaListas);
        listaListas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mostraProdutos = new Intent(ListaListViewActivity.this, ListaProdutosListViewActivity.class);
                mostraProdutos.putExtra("idLista", parent.getItemIdAtPosition(position));
                startActivity(mostraProdutos);
            }
        });

        Button btnAddLista = (Button) findViewById(R.id.addLista);
        btnAddLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListaListViewActivity.this);
                builder.setTitle("Digite o nome da lista:");

                final EditText nomeLista = new EditText(ListaListViewActivity.this);

                builder.setView(nomeLista);
                builder.setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ListaDao dao = new ListaDao(ListaListViewActivity.this);
                        Lista lista = new Lista();
                        lista.setNome(nomeLista.getEditableText().toString());
                        dao.insertOrUpdate(lista);
                        dao.close();

                        recarregaLista();
                    }
                });
                builder.setNegativeButton("Cancelar", null);
                builder.show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        recarregaLista();
    }

    public void recarregaLista() {
        ListaDao dao = new ListaDao(this);
        List<Lista> listas = dao.getLista();
        dao.close();

        ListaListasAdapter adapter = new ListaListasAdapter(this, listas);
        ListView listaListas = (ListView) findViewById(R.id.listaListas);
        listaListas.setAdapter(adapter);
    }
}
