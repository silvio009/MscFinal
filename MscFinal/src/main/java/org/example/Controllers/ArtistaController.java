package org.example.Controllers;

import org.example.Services.ArtistaService;
import org.example.model.Artista;

import java.util.List;
import java.util.Scanner;

public class ArtistaController {
    // facade
    private ArtistaService artistaService;
    private Scanner scanner;
    public ArtistaController(){
        this.artistaService =  new ArtistaService();
        this.scanner = new Scanner(System.in);
    }
    // facade

    public void CapturarEMontarArtista() {
        System.out.println("==== Adicionar Novo Artista ====");
        // Solicita o nome da música
        System.out.print("Digite o nome do artista: ");
        String nome = scanner.nextLine();


        // Monta o objeto artista
        Artista novoArtista = new Artista();
        novoArtista.setNome(nome);
        try {
            artistaService.save(novoArtista);
            System.out.println("artista adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar o artista: " + e.getMessage());
        }

    }
}
