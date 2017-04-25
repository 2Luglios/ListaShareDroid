package br.com.a2luglios.listasharedroid.modelo;

/**
 * Created by ettoreluglio on 25/04/17.
 */

public class Shared {

    private Long id;
    private String email;
    private String nome;
    private Long idLista;

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

    public Long getIdLista() {
        return idLista;
    }

    public void setIdLista(Long idLista) {
        this.idLista = idLista;
    }

    @Override
    public String toString() {
        return "" + nome;
    }
}
