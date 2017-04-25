package br.com.a2luglios.listasharedroid.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.a2luglios.listasharedroid.modelo.Compartilhamento;
import br.com.a2luglios.listasharedroid.modelo.Lista;
import br.com.a2luglios.listasharedroid.modelo.Produto;
import br.com.a2luglios.listasharedroid.modelo.Shared;
import br.com.a2luglios.listasharedroid.util.BancoUtil;

/**
 * Created by ettoreluglio on 19/04/17.
 */

public class ListaDao extends BancoUtil {

    public static final String TABELA = "LISTA";

    public static final String CREATEQUERY = "CREATE TABLE " + TABELA
            + "(" +
            "id INTEGER PRIMARY KEY," +
            "nome TEXT, " +
            "imagem BLOB);";

    public static final String UPDATEQUERY = "";
    private Context context;

    public ListaDao(Context context) {
        super(context);
        this.context = context;
    }

    public void insertOrUpdate(Lista lista) {
        getWritableDatabase().insert(TABELA, null, listaToContentValues(lista));
    }

    public void delete (Lista lista) {
        getWritableDatabase().delete(TABELA, "id=?", new String[]{lista.getId().toString()});
    }

    private ContentValues listaToContentValues(Lista lista) {
        ContentValues values = new ContentValues();
        values.put("id", lista.getId());
        values.put("nome", lista.getNome());
        values.put("imagem", lista.getImagem());

        return values;
    }

    public List<Lista> getLista() {
        List<Lista> listas = new ArrayList<>();

        Cursor c = getWritableDatabase().query(TABELA, null, null, null, null, null, null);

        while (c.moveToNext()) {
            Lista lista = new Lista();

            lista.setId(c.getLong(c.getColumnIndex("id")));
            lista.setNome(c.getString(c.getColumnIndex("nome")));
            lista.setImagem(c.getBlob(c.getColumnIndex("imagem")));

            List<Produto> produtos = new ProdutoDao(context).listaProdutosPorIdLista(lista.getId());
            lista.setProdutos(produtos);

            List<Shared> shareds = new SharedDao(context).listaSharedsPorIdLista(lista.getId());
            lista.setShared(shareds);

            listas.add(lista);
        }

        return listas;
    }
}
