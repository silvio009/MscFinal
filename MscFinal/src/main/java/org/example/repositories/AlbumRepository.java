package org.example.repositories;

import org.example.model.Album;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumRepository extends BaseRepository implements  IRepository<Album>{
    @Override
    public Album findById(Long id) throws Exception {
        String query = "SELECT * FROM ALBUM WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Album album = new Album();
                    album.setId(rs.getLong("id"));
                    album.setNome(rs.getString("nome"));
                    album.setDuracao(rs.getDouble("duracao"));
                    album.setAnoLancamento(rs.getInt(2015));
                    return album;
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
    public List<Album> findAll() throws Exception {
        List<Album> albuns = new ArrayList<>();
        String query = "SELECT * FROM ALBUM";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Album album= new Album();
                album.setId(rs.getLong("id"));
                album.setNome(rs.getString("nome"));
                album.setDuracao(rs.getDouble("duracao"));
                album.setAnoLancamento(rs.getInt(2015));
            }
        }
        return albuns;
    }

    @Override
    public void save(Album album) throws Exception {
        String query = "INSERT INTO ALBUM (id, nome, duracao , ano de lançamento) VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setLong(1, album.getId());
            ps.setString(2, album.getNome());
            ps.setDouble(3, album.getDuracao());
            ps.setInt(4, album.getAnoLancamento());
            ps.executeUpdate();
        }
    }

    @Override
    public void update(Album album) throws Exception {
        String query = "UPDATE ALBUM SET nome = ?, duracao = ? WHERE id = ?, ano de lançamento = ? ";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setLong(1, album.getId());
            ps.setString(2, album.getNome());
            ps.setDouble(3, album.getDuracao());
            ps.setInt(4, album.getAnoLancamento());
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
