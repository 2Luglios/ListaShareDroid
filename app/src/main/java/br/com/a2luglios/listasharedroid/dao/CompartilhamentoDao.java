package br.com.a2luglios.listasharedroid.dao;

import android.content.ContentValues;
import android.content.Context;

import br.com.a2luglios.listasharedroid.modelo.Compartilhamento;
import br.com.a2luglios.listasharedroid.modelo.Produto;
import br.com.a2luglios.listasharedroid.util.BancoUtil;

/**
 * Created by ettoreluglio on 19/04/17.
 */

public class CompartilhamentoDao extends BancoUtil {

    public static final String TABELA = "PRODUTO";

    public static final String CREATEQUERY = "CREATE TABLE " + TABELA
            + "(" +
            "id INTEGER PRIMARY KEY," +
            "nome TEXT, " +
            "imagem BLOB, " +
            "email TEXT, " +
            "idLista INTEGER);";

    public static final String UPDATEQUERY = "";

    public CompartilhamentoDao(Context context) {
        super(context);
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
        values.put("idLista", compartilhamento.getIdLista());

        return values;
    }

}
