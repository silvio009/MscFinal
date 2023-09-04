package org.example.Services;

import org.example.model.Album;
import org.example.model.Artista;
import org.example.model.Playlist;
import org.example.repositories.PlaylistRepository;

import java.util.List;

public class PlaylistSevice {

    // facade
    private PlaylistRepository playlistRepository;
    public PlaylistSevice(){
        this.playlistRepository = new PlaylistRepository();
    }
    // facade

    public Playlist fildbyId(Long id) throws Exception{
        if( id == null || id <= 0 ) {
            throw new IllegalArgumentException("ID inválido fornecido:" + id);
        }
        return playlistRepository.findById(id);
    }
    public List<Playlist> fildAll() throws Exception{
        return playlistRepository.findAll();
    }

    public boolean save(Playlist playlist) throws Exception {
        if (playlist== null) {
            throw new IllegalArgumentException("a Playlist fornecida é nula");
        }
        if (playlist.getNome() == null || playlist.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da playlist é inválido");
        }
        if (playlist.getDuracao() <= 0) {
            throw new IllegalArgumentException("Duração da playlist é inválida: " + playlist.getDuracao());
        }if (playlist.getMusicas() ==null){
            throw new IllegalArgumentException("A playlist não possui musicas" + playlist.getMusicas());
        }
        playlistRepository.save(playlist);
        return true;
    }
    public void update(Playlist playlist) throws Exception{
        if(playlist == null){
            throw new IllegalArgumentException("a playlist não o foi encontrada");
        }
        playlistRepository.update(playlist);
    }
    public void delete(Long id) throws Exception{
        if(id == null || id <= 0 ){
            throw new IllegalArgumentException(" O ID da playlist nã o foi encontrado" + id);
        }
    }
}
