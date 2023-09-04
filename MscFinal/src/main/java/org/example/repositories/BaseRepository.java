package org.example.repositories;

import java.sql.Connection;
import java.sql.DriverManager;


// ESSA CLASSE É RESPONSAVEL POR CONECTAR COM O BANCO DE DADOS, TODAS AS CLASSE REPOSITORY VÃO HERDAR ESSA CONEXÃO COM O EXTENDS
public class BaseRepository {

    protected static final String DB_URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    protected static final String USER = "RMXXXXXX";
    protected static final String PASS = "XXXXXX";

    protected Connection getConnection() throws Exception {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
