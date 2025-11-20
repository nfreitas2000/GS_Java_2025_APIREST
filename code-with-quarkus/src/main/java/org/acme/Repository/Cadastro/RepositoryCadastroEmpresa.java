package org.acme.Repository.Cadastro;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTO.DTOEmpresa;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@ApplicationScoped
public class RepositoryCadastroEmpresa {
    @Inject
    DataSource dataSource;

    public void inserirEmpresa (DTOEmpresa empresa) throws SQLException {
        String sql = "insert into T_LU_EMPRESA (nome_empresa, cnpj, setor, data_criacao) values (?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'))";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql))
        {
            ps.setString(1, empresa.getNome());
            ps.setString(2, empresa.getCnpj());
            ps.setString(3, empresa.getSetor());
            ps.setString(4, empresa.getData_criacao());

            ps.executeUpdate();
        }
    }



}
