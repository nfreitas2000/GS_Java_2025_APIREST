package org.acme.Service.Login;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.acme.Model.DTO.Empresa.DTOEmpresaLogin;
import org.acme.Repository.Login.RepositoryLoginEmpresa;


import java.sql.SQLException;

@ApplicationScoped
public class ServiceLoginEmpresa {
    @Inject
    RepositoryLoginEmpresa repositoryLoginEmpresa;

    public int realizarLogin(DTOEmpresaLogin empresaLogin) throws SQLException {
        int id = repositoryLoginEmpresa.realizarLoginEmpresa(empresaLogin);
        if (id == 0) {
            throw new NotFoundException();
        }
        return id;
    }
}
