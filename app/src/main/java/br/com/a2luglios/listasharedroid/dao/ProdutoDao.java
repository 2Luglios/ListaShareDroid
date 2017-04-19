package br.com.a2luglios.listasharedroid.dao;

/**
 * Created by ettoreluglio on 19/04/17.
 */

public class ProdutoDao {

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
            "quantidade INTEGER);";

    public static final String UPDATEQUERY = "";



}
