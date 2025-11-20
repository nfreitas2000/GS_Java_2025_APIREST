package org.acme.Repository.Login;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTO.Usuario.DTOUsuario;
import org.acme.Model.DTO.Usuario.DTOUsuarioLogin;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@ApplicationScoped
public class RepositoryLoginUsuario {
    @Inject
    DataSource dataSource;

    public int realizarLoginUsuario (DTOUsuarioLogin usuario) throws SQLException {
        String sql = "SELECT id_usuario FROM T_LU_USUARIO WHERE email = ? AND senha = ?";
        int id = 0;

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario.getEmail_login_usuario());
            ps.setString(2, usuario.getSenha_login_usuario());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id_usuario");
            }
            return id;
        }
    }
}
