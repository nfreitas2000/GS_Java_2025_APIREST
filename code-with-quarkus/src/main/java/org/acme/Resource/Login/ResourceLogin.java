package org.acme.Resource.Login;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Model.DTO.Usuario.DTOUsuarioLogin;
import org.acme.Repository.Login.RepositoryLoginEmpresa;
import org.acme.Repository.Login.RepositoryLoginUsuario;
import org.acme.Service.Login.ServiceLoginEmpresa;
import org.acme.Service.Login.ServiceLoginUsuario;

import java.sql.SQLException;

@Path("/login")
@Consumes(MediaType.APPLICATION_JSON)
public class ResourceLogin {
    @Inject
    ServiceLoginUsuario serviceLoginUsuario;
    @Inject
    ServiceLoginEmpresa serviceLoginEmpresa;

    @GET
    @Path("/usuario")
    public Response realizarLoginUsuario(DTOUsuarioLogin dadosUsuario){
        try{
            int id = serviceLoginUsuario.realizarLogin(dadosUsuario);
            return Response.status(Response.Status.FOUND)
                    .entity(id).build();

        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro com a base de dados" + e).build();
        }
        catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Usuário não encontrado: " + e.getMessage()).build();
        }

    }
}
