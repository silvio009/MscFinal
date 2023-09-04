package org.example.model;

import java.util.List;

public class Playlist {

    private long id;

    private String nome;

    private List<Musica> musicas;
    private double duracao;

    public Playlist(long id, String nome, List<Musica> musicas) {
        this.id = id;
        this.nome = nome;
        this.musicas = musicas;
    }

    public Playlist() {

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

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", musicas=" + musicas +
                '}';
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public double getDuracao() {
        return duracao;
    }


}
