package org.example.Controllers;

import org.example.Services.MusicaService;
import org.example.model.Musica;

import java.util.Scanner;

public class MusicaController {
    // FACADE
    private MusicaService musicaService;
    private Scanner scanner;
    public MusicaController(){
        this.musicaService = new MusicaService();
        this.scanner = new Scanner(System.in);
    }
    // FACADE

    public void capturarEMontarMusica() {
        System.out.println("==== Adicionar Nova Música ====");

        // Solicita o nome da música
        System.out.print("Digite o nome da música: ");
        String nome = scanner.nextLine();

        // Solicita a duração da música
        double duracao = 0;
        boolean duracaoValida = false;
        while (!duracaoValida) {
            System.out.print("Digite a duração da música (em minutos): ");
            try {
                duracao = Double.parseDouble(scanner.nextLine());
                if (duracao <= 0) {
                    System.out.println("Duração deve ser um valor positivo.");
                } else {
                    duracaoValida = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido para a duração.");
            }
        }

        // Monta o objeto Música
        Musica novaMusica = new Musica();
        novaMusica.setNome(nome);
        novaMusica.setDuracao(duracao);

        // Salva a música usando o serviço
        try {
            musicaService.save(novaMusica);
            System.out.println("Música adicionada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar música: " + e.getMessage());
        }
    }
}
