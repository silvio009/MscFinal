package org.example.Services;

import org.example.model.Album;
import org.example.repositories.AlbumRepository;

import java.util.List;

public class AlbumService {

    //FACADE
    private AlbumRepository albumRepository;

    public AlbumService() {
        this.albumRepository = new AlbumRepository();
    }

    //FACADE
    public Album findById(Long id) throws Exception {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID do album fornecido é invalido");
        }
        return albumRepository.findById(id);
    }

    public List<Album> findAll() throws Exception {
        return albumRepository.findAll();
    }

    public boolean save(Album album) throws Exception {
        if (album == null) {
            throw new IllegalArgumentException("album fornecido é nulo");
        }
        if (album.getNome() == null || album.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do album é inválido");
        }
        if (album.getDuracao() <= 0) {
            throw new IllegalArgumentException("Duração do album é inválida: " + album.getDuracao());
        }
        if (album.getAnoLancamento() > 2024) {
            throw new IllegalArgumentException("album fornecido não foi lançado ainda");
        }
        if (album.getArtista() == null) {
            throw new IllegalArgumentException("o Artista selecionado não possui albums");
        }
        if (album.getMusicas() == null) {
            throw new IllegalArgumentException(" a musica selecionada não está nesse album");
        }
        albumRepository.save(album);
        return true;
    }

    public void update( Album album) throws Exception{
        if(album == null){
            throw new IllegalArgumentException("O album não o foi encontrado");
        }
        albumRepository.update(album);
    }

    public void delete (Long id) throws Exception{
        if( id == null || id <= 0){
            throw new IllegalArgumentException("O ID do album é nulo ou não doi encontrado ");
        }
        albumRepository.delete(id);
    }
}