package org.acme.Service.Login;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.acme.Model.DTO.Usuario.DTOUsuarioLogin;
import org.acme.Repository.Login.RepositoryLoginUsuario;

import java.sql.SQLException;

@ApplicationScoped
public class ServiceLoginUsuario {
    @Inject
    RepositoryLoginUsuario loginUsuario;

    public int realizarLogin(DTOUsuarioLogin usuarioLogin) throws SQLException {
        int id = loginUsuario.realizarLoginUsuario(usuarioLogin);
        if (id == 0) {
            throw new NotFoundException();
        }
        return id;
    }
}
