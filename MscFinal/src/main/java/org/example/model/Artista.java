package org.example.model;

import java.util.List;

public class Artista {

    private  long id;

    private String nome;

    private  List<Album> albuns;

    public Artista(long id, String nome, List<Album> albuns) {
        this.id = id;
        this.nome = nome;
        this.albuns = albuns;
    }

    public Artista() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Album> getAlbuns() {
        return albuns;
    }

    public void setAlbuns(List<Album> albuns) {
        this.albuns = albuns;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", albuns=" + albuns +
                '}';
    }
}



