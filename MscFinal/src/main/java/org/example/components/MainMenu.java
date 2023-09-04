package org.example.components;

import org.example.Controllers.AlbumController;
import org.example.Controllers.ArtistaController;
import org.example.Controllers.MusicaController;
import org.example.Controllers.PlaylistController;

import java.util.Scanner;

public class MainMenu {
    private ArtistaController artistaController;
    private AlbumController albumController;

    private PlaylistController playlistController;

    private MusicaController musicaController;
    private Scanner scanner;

    public MainMenu() {
        this.musicaController = new MusicaController();
        this.artistaController = new ArtistaController();
        this.albumController = new AlbumController();
        this.playlistController = new PlaylistController();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("==== Menu Principal ====");
            System.out.println("1. Adicionar nova música");
            System.out.println("2. Adicionar novo Artsita");
            System.out.println("3. Adicionar novo album");
            System.out.println("4. Adicionar novo playlist");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opcao) {
                case 1:
                    musicaController.capturarEMontarMusica();
                    break;
                case 2:artistaController.CapturarEMontarArtista();
                    break;
                case 3:albumController.CapturarEMontarAlbum();
                    break;
                case 4:playlistController.capturarEMontarPlaylist();
                    break;
                case 5:System.out.println("Saindo...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }
}

