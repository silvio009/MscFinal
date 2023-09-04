package org.example.Services;

import org.example.model.Artista;
import org.example.model.Musica;
import org.example.repositories.ArtistaRepository;

import java.util.List;

public class ArtistaService {
    // FACADE
    private ArtistaRepository  artistaRepository;
    public ArtistaService(){
        this.artistaRepository = new ArtistaRepository();
    }
    // FACADE

    // ERRO CASO O ID DO ARTISTA NÃO ESTEJA REGISTRADO
    public Artista findById(Long id) throws Exception {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID fornecido inválido: " + id);
        }
        return artistaRepository.findById(id);
    }
    // ERRO CASO O ID DO ARTISTA NÃO ESTEJA REGISTRADO


    // RETORNADO UMA LISTA DE ARTISTAS SELECIONADOS
    public List<Artista> findAll() throws Exception{
        return artistaRepository.findAll();
    }
    // RETORNADO UMA LISTA DE ARTISTAS SELECIONADOS
    public boolean save(Artista artista) throws Exception {
        if (artista == null) {
            throw new IllegalArgumentException("O Artista fornecido é nulo");
        }
        if (artista.getNome() == null || artista.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do Artista é inválido");
        }
        if (artista.getAlbuns() == null) {
            throw new IllegalArgumentException(" O album desse artista não está Disponivel");
        }
        artistaRepository.save(artista);

        return true;
    }
    // dando update no artista
    public void update(Artista artista) throws Exception{
        if(artista == null){
            throw new IllegalArgumentException("O artista não o foi encontrado");
        }
        artistaRepository.update(artista);
    }
    // dando update no artista
    public void dalete(Long id) throws Exception{
        if(id == null || id <= 0){
            throw new IllegalArgumentException("o id do artista é nulo ou não foi encontrado! ");
        }
        artistaRepository.delete(id);
    }
}





