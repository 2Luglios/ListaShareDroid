package br.com.a2luglios.listasharedroid.modelo;

import java.util.List;

/**
 * Created by ettoreluglio on 19/04/17.
 */

public class Lista {

    private Long id;
    private String nome;
    private byte[] imagem;
    private List<Produto> produtos;
    private List<Shared> shared;

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

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Shared> getShared() {
        return shared;
    }

    public void setShared(List<Shared> shared) {
        this.shared = shared;
    }
}
