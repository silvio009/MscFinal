package org.example.repositories;

import org.example.model.Musica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MusicaRepository extends BaseRepository implements IRepository<Musica>{
    @Override
    public Musica findById(Long id) throws Exception {
        String query = "SELECT * FROM musica WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Musica musica = new Musica();
                    musica.setId(rs.getLong("id"));
                    musica.setNome(rs.getString("nome"));
                    musica.setDuracao(rs.getDouble("duracao"));
                    return musica;
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
    public List<Musica> findAll() throws Exception {
        List<Musica> musicas = new ArrayList<>();
        String query = "SELECT * FROM musica";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Musica musica = new Musica();
                musica.setId(rs.getLong("id"));
                musica.setNome(rs.getString("nome"));
                musica.setDuracao(rs.getDouble("duracao"));
                musicas.add(musica);
            }
        }
        return musicas;
    }

    @Override
    public void save(Musica musica) throws Exception {
        String query = "INSERT INTO musica (id, nome, duracao) VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setLong(1, musica.getId());
            ps.setString(2, musica.getNome());
            ps.setDouble(3, musica.getDuracao());
            ps.executeUpdate();
        }
    }

    @Override
    public void update(Musica musica) throws Exception {
        String query = "UPDATE musica SET nome = ?, duracao = ? WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, musica.getNome());
            ps.setDouble(2, musica.getDuracao());
            ps.setLong(3, musica.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        String query = "DELETE FROM musica WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setLong(1, id);
            ps.executeUpdate();
        }
    }
}
