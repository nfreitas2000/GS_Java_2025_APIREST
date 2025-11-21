package org.acme.Repository.Cadastro;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTO.Usuario.DTOUsuario;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class RepositoryCadastroUsuario {
    @Inject
    DataSource dataSource;

    public void cadastarUsuario(DTOUsuario usuario) throws SQLException {
        int id = 0;
        String sql = "insert into T_LU_USUARIO (nome_usuario, email, senha, id_empresa) values (?, ?, ?, ?)";
        try (Connection con = dataSource.getConnection()){
            try (PreparedStatement ps = con.prepareStatement(sql))
            {
                 {
                    ps.setString(1, usuario.getNome_usuario());
                    ps.setString(2, usuario.getEmail());
                    ps.setString(3, usuario.getSenha());
                    ps.setInt(4, idNomeEmpresa(usuario.getNm_empresa()));
                    ps.executeUpdate();
                }
            }
            sql = "SELECT id_usuario FROM T_LU_USUARIO WHERE email = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, usuario.getEmail());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    id = rs.getInt(1);
                }
            }
            sql = "INSERT INTO T_LU_STATUS_USUARIO (id_usuario) VALUES (?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, id);
                ps.executeUpdate();
            }
        }
    }

    public List<String> listaNomeEmpresas() throws SQLException{
        String sql ="Select nome_empresa from T_LU_EMPRESA";
        try(
                Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        )
        {
            ResultSet rs = ps.executeQuery();
            List<String> nomesEmpresas = new ArrayList<>();
            while(rs.next()){
                nomesEmpresas.add(rs.getString(1));
            }
            return nomesEmpresas;
        }
    }

    public int idNomeEmpresa(String nomeEmpresa) throws SQLException{
        String sql ="Select id_empresa from T_LU_EMPRESA WHERE nome_empresa = ?";
        int id = 0;
        try(
                Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        )
        {
            ps.setString(1, nomeEmpresa);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                id = rs.getInt(1);
            }
            return id;
        }
    }
}
