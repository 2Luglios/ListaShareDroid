package br.com.a2luglios.listasharedroid.modelo;

import java.util.List;

/**
 * Created by ettoreluglio on 19/04/17.
 */

public class Lista {

    private Long id;
    private String nome;
    private String imagem;
    private List<Produto> produtos;
    private List<Compartilhamento> shared;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Compartilhamento> getShared() {
        return shared;
    }

    public void setShared(List<Compartilhamento> shared) {
        this.shared = shared;
    }
}
