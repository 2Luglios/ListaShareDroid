package br.com.a2luglios.listasharedroid;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import br.com.a2luglios.listasharedroid.dao.ListaDao;
import br.com.a2luglios.listasharedroid.dao.SharedDao;
import br.com.a2luglios.listasharedroid.modelo.Lista;
import br.com.a2luglios.listasharedroid.modelo.Shared;

public class ShareListViewActivity extends AppCompatActivity {

    private Long idLista ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_activity_layout);

        Button addShared = (Button) findViewById(R.id.addEmail);
        addShared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ShareListViewActivity.this);
                builder.setTitle("Digite o email:");

                final EditText email = new EditText(ShareListViewActivity.this);

                builder.setView(email);
                builder.setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedDao dao = new SharedDao(ShareListViewActivity.this);
                        Shared shared = new Shared();
                        shared.setNome(email.getEditableText().toString());
                        dao.insertOrUpdate(shared);
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
        idLista = getIntent().getLongExtra("idLista", 0);

        SharedDao dao = new SharedDao(this);
        List<Shared> shareds = dao.listaSharedsPorIdLista(idLista);
        dao.close();

        ListView listView = (ListView) findViewById(R.id.listaEmails);
        listView.setAdapter(new ArrayAdapter<Shared>(this, android.R.layout.simple_list_item_1, shareds));

    }
}
