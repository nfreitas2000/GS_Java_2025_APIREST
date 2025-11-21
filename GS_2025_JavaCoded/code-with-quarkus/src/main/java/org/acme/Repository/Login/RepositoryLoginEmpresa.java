package org.acme.Repository.Login;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTO.Empresa.DTOEmpresaLogin;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@ApplicationScoped
public class RepositoryLoginEmpresa {
    @Inject
    DataSource dataSource;

    public int realizarLoginEmpresa (DTOEmpresaLogin loginEmpresa) throws SQLException {
        String sql = "SELECT id_empresa FROM T_LU_EMPRESA_LOGIN WHERE email_corporativo = ? AND senha_corporativa = ?";
        int id = 0;

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, loginEmpresa.getEmail_login_empresa());
            ps.setString(2, loginEmpresa.getSenha_login_empresa());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id_empresa");
            }
            return id;
        }
    }
}
