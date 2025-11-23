package org.acme.Repository.Desafios;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.acme.Model.ModelDesafio;
import org.acme.Model.ModelDesafioAceito;
import org.acme.Model.ModelStatus;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class RepositoryDesafiosUsuario {
    @Inject
    DataSource dataSource;

    public List<ModelDesafio> readDesafiosUsuarioEmpresa(int idUsuario) throws SQLException {

        String sql = "SELECT d.id_desafio, d.id_empresa, d.categoria, d.titulo, d.descricao, d.xp_recompensa, d.dificuldade, d.ativo, d.data_criacao FROM T_LU_DESAFIO d WHERE d.id_empresa = (SELECT id_empresa FROM T_LU_USUARIO WHERE id_usuario = ?) AND d.ativo = 'S'";

        List<ModelDesafio> lista = new ArrayList<>();

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new ModelDesafio(
                            rs.getInt("id_desafio"),
                            rs.getInt("id_empresa"),
                            rs.getString("categoria"),
                            rs.getString("titulo"),
                            rs.getString("descricao"),
                            rs.getInt("xp_recompensa"),
                            rs.getString("dificuldade"),
                            rs.getString("data_criacao"),
                            rs.getString("ativo")
                    ));
                }
            }
        }
        return lista;
    }

    public void aceitarDesafio(int id_usuario, int id_desafio) throws SQLException{
        String sql = "INSERT INTO T_LU_PARTICIPACAO (id_usuario, id_desafio) VALUES (?, ?)";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql))
        {
            ps.setInt(1, id_usuario);
            ps.setInt(2, id_desafio);

            ps.executeUpdate();
        }
    }

    public void concluirDesafio(int idUsuario, int idDesafio) throws SQLException {

        String sqlUpdateParticipacao = "UPDATE T_LU_PARTICIPACAO SET status = 'concluido', data_conclusao = SYSDATE WHERE id_usuario = ? AND id_desafio = ? AND status <> 'concluido'";

        String sqlBuscarXP = "SELECT xp_recompensa FROM T_LU_DESAFIO WHERE id_desafio = ?";

        String sqlAtualizarXP = "UPDATE T_LU_STATUS_USUARIO SET xp_atual = xp_atual + ?, xp_total = xp_total + ? WHERE id_usuario = ?";

        String sqlBuscarStatus = "SELECT nivel_atual, xp_atual, desafios_concluidos FROM T_LU_STATUS_USUARIO WHERE id_usuario = ?";

        String sqlUpLevel = "UPDATE T_LU_STATUS_USUARIO SET nivel_atual = ?, xp_atual = ?, desafios_concluidos = ? WHERE id_usuario = ?";

        String sqlNoUpLevel = "UPDATE T_LU_STATUS_USUARIO SET desafios_concluidos = desafios_concluidos + 1 WHERE id_usuario = ?";

        try (Connection con = dataSource.getConnection()) {

            con.setAutoCommit(false);

            int linhasAtualizadas;
            try (PreparedStatement ps = con.prepareStatement(sqlUpdateParticipacao)) {
                ps.setInt(1, idUsuario);
                ps.setInt(2, idDesafio);
                linhasAtualizadas = ps.executeUpdate();
            }

            if (linhasAtualizadas == 0) {
                con.rollback();
                throw new IllegalArgumentException("Desafio não está pendente para este usuário.");
            }

            int xpGanho;
            try (PreparedStatement ps = con.prepareStatement(sqlBuscarXP)) {
                ps.setInt(1, idDesafio);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) throw new IllegalArgumentException("Desafio não encontrado.");
                    xpGanho = rs.getInt("xp_recompensa");
                }
            }

            try (PreparedStatement ps = con.prepareStatement(sqlAtualizarXP)) {
                ps.setInt(1, xpGanho);
                ps.setInt(2, xpGanho);
                ps.setInt(3, idUsuario);
                ps.executeUpdate();
            }

            int nivelAtual, xpAtual, desafiosConcluidos;
            try (PreparedStatement ps = con.prepareStatement(sqlBuscarStatus)) {
                ps.setInt(1, idUsuario);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) throw new IllegalArgumentException("Status do usuário não encontrado.");
                    nivelAtual = rs.getInt("nivel_atual");
                    xpAtual = rs.getInt("xp_atual");
                    desafiosConcluidos = rs.getInt("desafios_concluidos");
                }
            }

            int limite = nivelAtual * 1000;

            if (xpAtual >= limite) {
                int novoNivel = nivelAtual + 1;
                int xpRestante = xpAtual - limite;
                int novoDesafios = desafiosConcluidos + 1;

                try (PreparedStatement ps = con.prepareStatement(sqlUpLevel)) {
                    ps.setInt(1, novoNivel);
                    ps.setInt(2, xpRestante);
                    ps.setInt(3, novoDesafios);
                    ps.setInt(4, idUsuario);
                    ps.executeUpdate();
                }
            } else {
                try (PreparedStatement ps = con.prepareStatement(sqlNoUpLevel)) {
                    ps.setInt(1, idUsuario);
                    ps.executeUpdate();
                }
            }
            con.commit();
        }
    }

    public List<ModelDesafioAceito> listarDesafiosAceitos(int idUsuario) throws SQLException {

        String sql = "SELECT p.id_participacao, p.id_usuario, p.id_desafio, p.status, p.data_inicio, p.data_conclusao, d.id_empresa, d.categoria, d.titulo, d.descricao, d.xp_recompensa, d.dificuldade, d.data_criacao, d.ativo FROM T_LU_PARTICIPACAO p JOIN T_LU_DESAFIO d ON d.id_desafio = p.id_desafio WHERE p.id_usuario = ? ORDER BY p.data_inicio DESC";

        List<ModelDesafioAceito> lista = new ArrayList<>();

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new ModelDesafioAceito(
                            rs.getInt("id_participacao"),
                            rs.getInt("id_usuario"),
                            rs.getInt("id_desafio"),
                            rs.getString("status"),
                            rs.getString("data_inicio"),
                            rs.getString("data_conclusao"),
                            rs.getString("categoria"),
                            rs.getString("titulo"),
                            rs.getString("descricao"),
                            rs.getInt("xp_recompensa"),
                            rs.getString("dificuldade"),
                            rs.getString("data_criacao"),
                            rs.getString("ativo")
                    ));
                }
            }
        }
        return lista;
    }

    public ModelStatus recuperarStatus(int id_usuario) throws SQLException {
        String sql = "SELECT * FROM T_LU_STATUS_USUARIO WHERE id_usuario = ?";

        ModelStatus stats = null;
        try (Connection con = dataSource.getConnection();
                                      PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id_usuario);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    stats = new ModelStatus(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                }
            }
        }
        return stats;
    }


}
