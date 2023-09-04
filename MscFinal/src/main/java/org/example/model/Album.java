package org.example.model;

import java.util.List;

public class Album {

    private String nome;

    private long id;

    private int anoLancamento;

    private List<Musica> musicas;

    private Artista artista;

    private double duracao;

    public Album(String nome, long id, int anoLancamento, List<Musica> musicas, Artista artista, double duracao) {
        this.nome = nome;
        this.id = id;
        this.anoLancamento = anoLancamento;
        this.musicas = musicas;
        this.artista = artista;
        this.duracao = duracao;
    }

    public Album() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Album{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", anoLancamento=" + anoLancamento +
                ", musicas=" + musicas +
                ", artista=" + artista +
                '}';
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public double getDuracao() {
        return duracao;
    }
}
