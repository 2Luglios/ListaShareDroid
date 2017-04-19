package br.com.a2luglios.listasharedroid.dao;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ettoreluglio on 19/04/17.
 */

public class UsuarioDao {

    private SharedPreferences preferences;

    private String nome;
    private String email;
    private String senha;

    public UsuarioDao(Context ctx) {
        preferences = ctx.getSharedPreferences("USUARIO", Context.MODE_PRIVATE);
        nome = preferences.getString("nome", "");
        email = preferences.getString("email", "");
        senha = preferences.getString("senha", "");
    }

    public void save(){
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("nome", nome);
        edit.putString("email", email);
        edit.putString("senha", senha);
        edit.commit();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
