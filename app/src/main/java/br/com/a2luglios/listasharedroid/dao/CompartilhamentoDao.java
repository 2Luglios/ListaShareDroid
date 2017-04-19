package br.com.a2luglios.listasharedroid.dao;

/**
 * Created by ettoreluglio on 19/04/17.
 */

public class CompartilhamentoDao {

    public static final String TABELA = "PRODUTO";

    public static final String CREATEQUERY = "CREATE TABLE " + TABELA
            + "(" +
            "id INTEGER PRIMARY KEY," +
            "nome TEXT, " +
            "imagem BLOB, " +
            "email TEXT, " +
            "idLista INTEGER);";

    public static final String UPDATEQUERY = "";

}
