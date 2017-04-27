package br.com.a2luglios.listasharedroid.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Arrays;

import br.com.a2luglios.listasharedroid.dao.CompartilhamentoDao;
import br.com.a2luglios.listasharedroid.modelo.Compartilhamento;
import br.com.a2luglios.listasharedroid.modelo.Produto;

/**
 * Created by ettoreluglio on 19/04/17.
 */

public class DadosSync {

    private Context ctx;

    public DadosSync (Context ctx) {
        this.ctx = ctx;
    }

    public void carregaDados() {
        SharedPreferences prefs = ctx.getSharedPreferences("SYNC", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();

        if ( !prefs.getBoolean("carregou", false) ) {

            //Produto produto = new Produto();
            //produto.setNome("Sabao");
            //produto.setQuantidade(10);
            //produto.setMarca("OMO");

            Compartilhamento compartilhamento = new Compartilhamento();
            compartilhamento.setEmail("1@1.1");
            compartilhamento.setNome("LOXAS");
            //compartilhamento.setProdutos(Arrays.asList(produto));

            CompartilhamentoDao dao = new CompartilhamentoDao(ctx);
            dao.insertOrUpdate(compartilhamento);
            dao.close();

            edit.putBoolean("carregou", true);
            edit.commit();
        }

    }

}
