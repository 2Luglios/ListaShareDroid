package br.com.a2luglios.listasharedroid.dao;

import android.content.ContentValues;
import android.content.Context;

import br.com.a2luglios.listasharedroid.modelo.Produto;
import br.com.a2luglios.listasharedroid.util.BancoUtil;

/**
 * Created by ettoreluglio on 19/04/17.
 */

public class ProdutoDao extends BancoUtil {

    public static final String TABELA = "PRODUTO";

    public static final String CREATEQUERY = "CREATE TABLE " + TABELA
            + "(" +
            "id INTEGER PRIMARY KEY," +
            "nome TEXT, " +
            "checado INTEGER, " +
            "imagem BLOB, " +
            "marca TEXT, " +
            "opcional TEXT, " +
            "obs TEXT, " +
            "quantidade INTEGER, " +
            "idLista INTEGER);";

    public static final String UPDATEQUERY = "";

    public ProdutoDao(Context context) {
        super(context);
    }

    public void insertOrUpdate(Produto produto) {
        getWritableDatabase().insert(TABELA, null, produtoToContentValues(produto));
    }

    public void delete (Produto produto) {
        getWritableDatabase().delete(TABELA, "id=?", new String[]{produto.getId().toString()});
    }

    private ContentValues produtoToContentValues(Produto produto) {
        ContentValues values = new ContentValues();
        values.put("id", produto.getId());
        values.put("imagem", produto.getImagem());
        values.put("marca", produto.getMarca());
        values.put("nome", produto.getNome());
        values.put("obs", produto.getObs());
        values.put("opcional", produto.getOpcional());
        values.put("quantidade", produto.getQuantidade());
        values.put("idLista", produto.getIdLista());

        return values;
    }

}