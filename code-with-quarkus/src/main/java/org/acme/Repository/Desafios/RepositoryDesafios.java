package org.acme.Repository.Desafios;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.acme.Model.DTO.Desafio.DTOAtualizarDesafio;
import org.acme.Model.DTO.Desafio.DTODesafio;
import org.acme.Model.ModelDesafio;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class RepositoryDesafios {
    @Inject
    DataSource dataSource;

    public void inserirDesafio (DTODesafio desafio) throws SQLException {
        String sql = "insert into T_LU_DESAFIO(id_empresa, categoria, titulo, descricao, xp_recompensa, dificuldade) values (?, ?, ?, ?, ?, ?)";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql))
        {
            ps.setInt(1, desafio.getId_empresa());
            ps.setString(2, desafio.getCategoria());
            ps.setString(3, desafio.getTitulo());
            ps.setString(4, desafio.getDescricao());
            ps.setInt(5, desafio.getXp_recompensa());
            ps.setString(6, desafio.getDificuldade());

            ps.executeUpdate();
        }
    }
    public List<ModelDesafio> readDesafiosCadastradosEmpresa(int id) throws SQLException{
        String sql = "SELECT * FROM T_LU_DESAFIO WHERE id_empresa = ?";
        ArrayList<ModelDesafio> desafios = new ArrayList<ModelDesafio>();
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql))
        {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                desafios.add(new ModelDesafio(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getInt(6), rs.getString(7),rs.getString(8),rs.getString(9)));
            }
            return desafios;
        }
    }

    public void atualizarDesafios(DTOAtualizarDesafio desafio) throws SQLException {
        String sql = "UPDATE T_LU_DESAFIO SET categoria = ?, titulo = ?, descricao = ?, xp_recompensa = ?, dificuldade = ?, ativo = ? WHERE id_desafio = ?";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql))
        {
            ps.setString(1, desafio.getCategoria());
            ps.setString(2, desafio.getTitulo());
            ps.setString(3, desafio.getDescricao());
            ps.setInt(4, desafio.getXp_recompensa());
            ps.setString(5, desafio.getDificuldade());
            ps.setString(6, desafio.getAtivo());
            ps.setInt(7, desafio.getId_desafio());

            int linhas = ps.executeUpdate();
            if (linhas == 0) {
                throw new NotFoundException("Desafio não encontrado");
            }
        }
    }

    public void deletarDesafio(int id) throws SQLException{
        String sql = "Delete from T_LU_DESAFIO where id_desafio = ?";

        try (Connection con = dataSource.getConnection()) {
            con.setAutoCommit(false);

            try (PreparedStatement st = con.prepareStatement(sql)) {
                st.setInt(1, id);
                int funcionou = st.executeUpdate();
                if (funcionou > 0) {
                    con.commit();
                } else {
                    con.rollback();
                    throw new NotFoundException ("ID não encontrado");
                }
            }
        }
    }
}
