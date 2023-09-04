package org.example.Controllers;

import org.example.Services.AlbumService;
import org.example.model.Album;

import java.util.Scanner;

public class AlbumController {

    private AlbumService albumService;
    private Scanner scanner;

    public AlbumController(){
        this.albumService = new AlbumService();
        this.scanner = new Scanner(System.in);
    }

    public void CapturarEMontarAlbum(){
        System.out.println("==== Adicionar Novo album ====");
        // Solicita o nome do album
        System.out.print("Digite o nome do album: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o ano de lançamento desse album: ");
        int AnoDeLancamento = Integer.parseInt(scanner.nextLine());

        Album novoalbum = new Album();
        novoalbum.setNome(nome);
        novoalbum.setAnoLancamento(AnoDeLancamento);
        try {
            albumService.save(novoalbum);
            System.out.println("Música adicionada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar música: " + e.getMessage());
        }    }
}
