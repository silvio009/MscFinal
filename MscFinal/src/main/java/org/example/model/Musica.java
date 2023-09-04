package org.example.model;

public class Musica {

    private long id;

    private String nome;

    private double duracao;

    private Artista artista;



    public Musica(long id, String nome, double duracao, Artista artista) {
        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
        this.artista = artista;
    }

    public Musica() {

    }

    public  long getId() {
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

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Musica{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", duracao=" + duracao +
                ", artista=" + artista +
                '}';
    }
}
