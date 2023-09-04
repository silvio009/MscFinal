package org.example.repositories;

import org.example.model.Artista;
import org.example.model.Playlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistaRepository extends BaseRepository implements IRepository<Artista>{
    @Override
    public Artista findById(Long id) throws Exception {
        String query = "SELECT * FROM ARTISTA WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Artista artista = new Artista();
                    artista.setId(rs.getLong("id"));
                    artista.setNome(rs.getString("nome"));
                    return artista;
                }
            }
        }
        catch (SQLException e) {
            if(e.getErrorCode() == 1017) { // Erro de login/senha inválido
                throw new Exception("Falha de autenticação ao conectar ao banco de dados.", e);
            } else if(e.getErrorCode() == 904) { // Erro de coluna inválida
                throw new Exception("A query contém uma coluna inválida.", e);
            } else {
                throw new Exception("Erro ao executar a query.", e);
            }
        }
        return null;
    }

    @Override
    public List<Artista> findAll() throws Exception {
        List<Artista> artistas = new ArrayList<>();
        String query = "SELECT * FROM ARTISTA";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Artista artista = new Artista();
                artista.setId(rs.getLong("id"));
                artista.setNome(rs.getString("nome"));
            }
        }
        return artistas;
    }


    @Override
    public void save(Artista artista) throws Exception {
        String query = "INSERT INTO ARTISTA (id, nome,) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setLong(1, artista.getId());
            ps.setString(2, artista.getNome());
            ps.executeUpdate();
        }
    }

    @Override
    public void update(Artista artista) throws Exception {
        String query = "UPDATE ARTISTA SET nome = ?, albuns = ? WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, artista.getNome());
            ps.setLong(2, artista.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        String query = "DELETE FROM ARTISTA WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setLong(1, id);
            ps.executeUpdate();
        }
    }
}
