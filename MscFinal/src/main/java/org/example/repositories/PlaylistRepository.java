package org.example.repositories;

import org.example.model.Musica;
import org.example.model.Playlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistRepository  extends BaseRepository implements IRepository<Playlist>{
    @Override
    public Playlist findById(Long id) throws Exception {
        String query = "SELECT * FROM Playlist WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Playlist playlist= new Playlist();
                    playlist.setId(rs.getLong("id"));
                    playlist.setNome(rs.getString("nome"));
                    return playlist;
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
    public List<Playlist> findAll() throws Exception {
        List<Playlist> playlists= new ArrayList<>();
        String query = "SELECT * FROM PLAYLIST";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Playlist playlist= new Playlist();
                playlist.setId(rs.getLong("id"));
                playlist.setNome(rs.getString("nome"));
            }
        }
        return playlists;
    }


    @Override
    public void save(Playlist playlist) throws Exception {
        String query = "INSERT INTO PLAYLIST (id, nome, duracao) VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setLong(1, playlist.getId());
            ps.setString(2, playlist.getNome());
            ps.executeUpdate();
        }
    }

    @Override
    public void update(Playlist playlist) throws Exception {
        String query = "UPDATE PLAYLIST SET nome = ?, duracao = ? WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, playlist.getNome());
            ps.setLong(2, playlist.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        String query = "DELETE FROM PLAYLIST WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setLong(1, id);
            ps.executeUpdate();
        }
    }
}
