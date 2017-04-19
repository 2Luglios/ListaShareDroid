package br.com.a2luglios.listasharedroid.modelo;

/**
 * Created by ettoreluglio on 19/04/17.
 */

public class Compartilhamento {

    private Long id;
    private String email;
    private String nome;
    private String imagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
