package br.com.a2luglios.listasharedroid.dao;

import java.util.List;

import br.com.a2luglios.listasharedroid.modelo.Compartilhamento;
import br.com.a2luglios.listasharedroid.modelo.Produto;

/**
 * Created by ettoreluglio on 19/04/17.
 */

public class ListaDao {

    public static final String TABELA = "LISTA";

    public static final String CREATEQUERY = "CREATE TABLE " + TABELA
            + "(" +
            "id INTEGER PRIMARY KEY," +
            "nome TEXT, " +
            "imagem BLOB, " +
            "produtoID INTEGER, " +
            "sharedID INTEGER);";

    public static final String UPDATEQUERY = "";


}
