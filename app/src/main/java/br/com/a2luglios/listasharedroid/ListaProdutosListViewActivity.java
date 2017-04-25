package br.com.a2luglios.listasharedroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import br.com.a2luglios.listasharedroid.adapters.ListaProdutosAdapter;
import br.com.a2luglios.listasharedroid.dao.ProdutoDao;
import br.com.a2luglios.listasharedroid.modelo.Produto;

public class ListaProdutosListViewActivity extends AppCompatActivity {

    private Long idLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_produtos_activity_layout);

        final ListView listaProdutos = (ListView) findViewById(R.id.listaProdutos);
        listaProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        Button btnAddProduto = (Button) findViewById(R.id.addProdutos);
        btnAddProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent novoProduto = new Intent(ListaProdutosListViewActivity.this, CadastroProdutosActivity.class);
                novoProduto.putExtra("idLista", idLista);
                startActivity(novoProduto);
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

        ProdutoDao dao = new ProdutoDao(this);
        List<Produto> produtos = dao.listaProdutosPorIdLista(idLista);
        dao.close();

        ListView listaProdutos = (ListView) findViewById(R.id.listaProdutos);
        ListaProdutosAdapter adapter = new ListaProdutosAdapter(ListaProdutosListViewActivity.this, produtos);
        listaProdutos.setAdapter(adapter);
    }
}
