package org.acme.Resource.Cadastro;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Model.DTO.Empresa.DTOEmpresa;
import org.acme.Model.DTO.Usuario.DTOUsuario;
import org.acme.Service.Cadastro.ServiceCadastroEmpresa;
import org.acme.Service.Cadastro.ServiceCadastroUsuario;

import java.sql.SQLException;
import java.util.List;

@Path("/cadastro")
@Consumes(MediaType.APPLICATION_JSON)
public class ResourceCadastro {
    @Inject
    ServiceCadastroEmpresa serviceCadastroEmpresa;
    @Inject
    ServiceCadastroUsuario serviceCadastroUsuario;

    @Path("/empresa")
    @POST
    public Response cadastrarEmpresa(DTOEmpresa empresa){
        try{
            serviceCadastroEmpresa.inserir(empresa);
            return Response.status(Response.Status.CREATED)
                    .entity("Criado com Sucesso").build();

        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro com a base de dados" + e).build();
        }
        catch (IllegalArgumentException e) {
            return Response.status(422).entity(e.getMessage()).build();
        }
    }

    @Path("/empresa/lista")
    @GET
    public Response listarEmpresas(){
        try{
            List<String> lista = serviceCadastroUsuario.listaEmpresas();
            return Response.status(Response.Status.OK)
                    .entity(lista).build();

        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro com a base de dados" + e).build();
        }
        catch (IndexOutOfBoundsException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @Path("/usuario")
    @POST
    public Response cadastrarUsuario(DTOUsuario usuario){
        try{
            serviceCadastroUsuario.inserir(usuario);
            return Response.status(Response.Status.CREATED) /*201*/
                    .entity("Criado com Sucesso").build();

        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro com a base de dados" + e).build();
        }
        catch (IllegalArgumentException e) {
            return Response.status(422).entity(e.getMessage()).build();
        }
    }
}
