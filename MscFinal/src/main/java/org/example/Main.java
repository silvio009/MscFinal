package org.example;

import org.example.components.MainMenu;
import org.example.infraestructure.DatabaseSetup;

import static org.example.infraestructure.DatabaseSetup.createTables;

public class Main {
    public static void main(String[] args) {
        DatabaseSetup setup = new DatabaseSetup();
        createTables();
        MainMenu menu = new MainMenu();
        menu.exibirMenu();
    }
}