package br.com.a2luglios.listasharedroid.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.a2luglios.listasharedroid.modelo.Compartilhamento;
import br.com.a2luglios.listasharedroid.modelo.Produto;
import br.com.a2luglios.listasharedroid.util.BancoUtil;

/**
 * Created by ettoreluglio on 19/04/17.
 */

public class CompartilhamentoDao extends BancoUtil {

    public static final String TABELA = "COMPARTILHAMENTO";

    public static final String CREATEQUERY = "CREATE TABLE " + TABELA
            + "(" +
            "id INTEGER PRIMARY KEY," +
            "nome TEXT, " +
            "imagem BLOB, " +
            "email TEXT);";

    public static final String UPDATEQUERY = "";
    private Context context;

    public CompartilhamentoDao(Context context) {
        super(context);
        this.context = context;
    }

    public void insertOrUpdate(Compartilhamento compartilhamento) {
        getWritableDatabase().insert(TABELA, null, compartilhamentoToContentValues(compartilhamento));
    }

    public void delete (Compartilhamento compartilhamento) {
        getWritableDatabase().delete(TABELA, "id=?", new String[]{compartilhamento.getId().toString()});
    }

    private ContentValues compartilhamentoToContentValues(Compartilhamento compartilhamento) {
        ContentValues values = new ContentValues();
        values.put("id", compartilhamento.getId());
        values.put("nome", compartilhamento.getNome());
        values.put("imagem", compartilhamento.getImagem());
        values.put("email", compartilhamento.getEmail());

        return values;
    }

    public List<Compartilhamento> lista() {
        List<Compartilhamento> lista = new ArrayList<>();

        Cursor c = getWritableDatabase().query(TABELA, null, null, null, null, null, null);
        while (c.moveToNext()){
            Compartilhamento compartilhamento = new Compartilhamento();
            compartilhamento.setId(c.getLong(c.getColumnIndex("id")));
            compartilhamento.setNome(c.getString(c.getColumnIndex("nome")));
            compartilhamento.setImagem(c.getBlob(c.getColumnIndex("imagem")));
            compartilhamento.setEmail(c.getString(c.getColumnIndex("email")));

            List<Produto> produtos = new ProdutoDao(context).listaProdutosPorIdLista(compartilhamento.getId());
            compartilhamento.setProdutos(produtos);

            lista.add(compartilhamento);
        }

        return lista;
    }
}
