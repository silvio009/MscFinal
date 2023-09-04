package org.example.Controllers;

import org.example.Services.PlaylistSevice;
import org.example.model.Playlist;

import java.util.Scanner;

public class PlaylistController {

    private PlaylistSevice playlistSevice;

    private Scanner scanner;

    public  PlaylistController(){
        this.playlistSevice =new PlaylistSevice();
        this.scanner = new Scanner(System.in);
    }
    public void capturarEMontarPlaylist() {
        System.out.println("==== Adicionar Nova Playlist ====");

        // Solicita o nome da playlist
        System.out.print("Digite o nome da playlist: ");
        String nome = scanner.nextLine();


        // Monta o objeto Música
        Playlist novaPLAYLIST = new Playlist();
        novaPLAYLIST.setNome(nome);

        // Salva a música usando o serviço
        try {
            playlistSevice.save(novaPLAYLIST);
            System.out.println("a playlist adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar a playlist: " + e.getMessage());
        }
    }
}
