package org.acme.Repository.Cadastro;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTO.Empresa.DTOEmpresa;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@ApplicationScoped
public class RepositoryCadastroEmpresa {
    @Inject
    DataSource dataSource;

    public void inserirEmpresa(DTOEmpresa empresa) throws SQLException {
        String sqlInsert = "INSERT INTO T_LU_EMPRESA (nome_empresa, cnpj, setor, data_criacao) VALUES (?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'))";
        int idEmpresa = 0;
        try (Connection con = dataSource.getConnection()) {
            try (PreparedStatement ps = con.prepareStatement(sqlInsert)) {
                ps.setString(1, empresa.getNome());
                ps.setString(2, empresa.getCnpj());
                ps.setString(3, empresa.getSetor());
                ps.setString(4, empresa.getData_criacao());
                ps.executeUpdate();
            }
            String sqlSelect = "SELECT id_empresa FROM T_LU_EMPRESA WHERE cnpj = ?";
            try (PreparedStatement ps = con.prepareStatement(sqlSelect)) {
                ps.setString(1, empresa.getCnpj());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    idEmpresa = rs.getInt(1);
                }
            }
            String sqlInsertLogin = "INSERT INTO T_LU_EMPRESA_LOGIN (email_corporativo, senha_corporativa, id_empresa) VALUES (?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(sqlInsertLogin)) {
                ps.setString(1, empresa.getEmail_coporativo());
                ps.setString(2, empresa.getSenha_coporativa());
                ps.setInt(3, idEmpresa);
                ps.executeUpdate();
            }
        }
    }
}
