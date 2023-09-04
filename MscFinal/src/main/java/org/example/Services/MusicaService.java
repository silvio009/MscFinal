package org.example.Services;

import org.example.model.Musica;
import org.example.repositories.MusicaRepository;

import java.util.List;

public class MusicaService {
    // FACADE
    private MusicaRepository musicaRepository;

    public MusicaService(){
        this.musicaRepository = new MusicaRepository();
    }
    // FACADE
    // ERRO CASO O USUARIO TENTE COLOCAR UM ID INVALIDO PARA A MUSICA
    public Musica findbyId(Long id) throws Exception{
        if (id == null || id <= 0){
            throw new IllegalArgumentException("O ID está invalido:"+ id+  "tente novamente");
        }
        return musicaRepository.findById(id);
    }
    // ERRO CASO O USUARIO TENTE COLOCAR UM ID INVALIDO PARA A MUSICA



    // RETORNADO TODAS AS MUSICAS SELECIONADAS
    public List<Musica> findall() throws Exception{
        return musicaRepository.findAll();
    }
    // RETORNADO TODAS AS MUSICAS SELECIONADAS

    // ERROS SOBRE MUSICAS || NOME || DURAÇÃO
    public boolean save(Musica musica) throws Exception {
        if (musica == null) {
            throw new IllegalArgumentException("Música fornecida é nula");
        }
        if (musica.getNome() == null || musica.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da música é inválido");
        }
        if (musica.getDuracao() <= 0) {
            throw new IllegalArgumentException("Duração da música é inválida: " + musica.getDuracao());
        }
        musicaRepository.save(musica);
        return true;
    }
    // ERROS SOBRE MUSICAS || NOME || DURAÇÃO
    //UPDATE
    public  void update(Musica musica) throws Exception{
        if(musica == null){
            throw new IllegalArgumentException("Não á musicas para serem adicionadas");
        }
        musicaRepository.update(musica);
    }
    //UPDATE
    public void dalete(Long id) throws Exception{
        if(id == null || id <= 0){
            throw new IllegalArgumentException("o id da musica selecionada é nulo ou não foi encontrada");
        }
       musicaRepository.delete(id);
    }
}
