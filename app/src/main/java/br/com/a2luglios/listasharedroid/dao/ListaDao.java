package br.com.a2luglios.listasharedroid.dao;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.a2luglios.listasharedroid.modelo.Compartilhamento;
import br.com.a2luglios.listasharedroid.modelo.Lista;
import br.com.a2luglios.listasharedroid.modelo.Produto;
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

    public ListaDao(Context context) {
        super(context);
    }

    public List<Lista> getLista() {
        List<Lista> listas = new ArrayList<>();

        Cursor c = getWritableDatabase().query(TABELA, null, null, null, null, null, null);

        while (c.moveToNext()) {
            Lista lista = new Lista();

            lista.setId(c.getLong(c.getColumnIndex("id")));
            lista.setNome(c.getString(c.getColumnIndex("nome")));
            lista.setImagem(c.getBlob(c.getColumnIndex("imagem")));

            Cursor cursorDeProdutos = getWritableDatabase().query(ProdutoDao.TABELA, null,
                    "idLista=?", new String[]{lista.getId().toString()}, null, null, null);

            List<Produto> produtos = new ArrayList<>();
            while(cursorDeProdutos.moveToNext()) {
                Produto produto = new Produto();
                produto.setId(cursorDeProdutos.getLong(cursorDeProdutos.getColumnIndex("id")));
                produto.setImagem(cursorDeProdutos.getBlob(cursorDeProdutos.getColumnIndex("imagem")));
                produto.setNome(cursorDeProdutos.getString(cursorDeProdutos.getColumnIndex("nome")));
                produto.setChecado(cursorDeProdutos.getInt(cursorDeProdutos.getColumnIndex("checado")) == 0 ? false : true);
                produto.setMarca(cursorDeProdutos.getString(cursorDeProdutos.getColumnIndex("marca")));
                produto.setOpcional(cursorDeProdutos.getString(cursorDeProdutos.getColumnIndex("opcional")));
                produto.setObs(cursorDeProdutos.getString(cursorDeProdutos.getColumnIndex("obs")));
                produto.setQuantidade(cursorDeProdutos.getInt(cursorDeProdutos.getColumnIndex("quantidade")));
                produtos.add(produto);
            }
            lista.setProdutos(produtos);

            Cursor cursorDeCompartilhamentos = getWritableDatabase().query(CompartilhamentoDao.TABELA,
                    null, "idLista=?", new String[]{lista.getId().toString()}, null, null, null);

            List<Compartilhamento> compartilhamentos = new ArrayList<>();
            while(cursorDeCompartilhamentos.moveToNext()) {
                Compartilhamento compartilhamento = new Compartilhamento();
                compartilhamento.setId(cursorDeCompartilhamentos.getLong(cursorDeCompartilhamentos.getColumnIndex("id")));
                compartilhamento.setNome(cursorDeCompartilhamentos.getString(cursorDeCompartilhamentos.getColumnIndex("nome")));
                compartilhamento.setEmail(cursorDeCompartilhamentos.getString(cursorDeCompartilhamentos.getColumnIndex("email")));
                compartilhamento.setImagem(cursorDeCompartilhamentos.getBlob(cursorDeCompartilhamentos.getColumnIndex("imagem")));
                compartilhamentos.add(compartilhamento);
            }
            lista.setShared(compartilhamentos);

            listas.add(lista);
        }

        return listas;
    }
}
