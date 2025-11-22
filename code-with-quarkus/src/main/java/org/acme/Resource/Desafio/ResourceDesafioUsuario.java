package org.acme.Resource.Desafio;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.acme.Model.ModelDesafio;
import org.acme.Model.ModelDesafioAceito;
import org.acme.Model.ModelStatus;
import org.acme.Service.Desafio.ServiceDesafioUsuario;

import java.sql.SQLException;
import java.util.List;

@Path("/desafiosUsuario")
public class ResourceDesafioUsuario {
    @Inject
    ServiceDesafioUsuario serviceDesafioUsuario;

    @Path("/disponiveis/{id}")
    @GET
    public Response desafiosUsuarioEmpresa(@PathParam("id") int id){
        try{
            List<ModelDesafio> lista = serviceDesafioUsuario.desafiosUsuarioEmpresa(id);
            return Response.status(Response.Status.OK)
                    .entity(lista).build();

        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro com a base de dados" + e).build();
        } catch (NotFoundException e){
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage()).build();
        }
    }
    @Path("/aceitar/{idUser}/{idDesafio}")
    @POST
    public Response desafioAceitar(@PathParam("idUser") int id_usuario, @PathParam("idDesafio") int id_desafio){
        try{
            serviceDesafioUsuario.aceitarDesafio(id_usuario, id_desafio);
            return Response.status(Response.Status.CREATED)
                    .entity("Desafio aceito com sucesso!").build();

        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro com a base de dados" + e).build();
        } catch (IllegalArgumentException e){
            return Response.status(422)
                    .entity(e.getMessage()).build();
        }
    }

    @Path("/concluirDesafio/{idUser}/{idDesafio}")
    @PUT
    public Response finalizarDesafio(@PathParam("idUser") int id_usuario, @PathParam("idDesafio") int id_desafio){
        try{
            serviceDesafioUsuario.finalizarDesafio(id_usuario, id_desafio);
            return Response.status(Response.Status.OK)
                    .entity("Desafio finalizado com sucesso!").build();

        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro com a base de dados" + e).build();
        } catch (IllegalArgumentException e){
            return Response.status(422)
                    .entity(e.getMessage()).build();
        }
    }

    @Path("/desafiosAceitos/{id}")
    @GET
    public Response desafiosAceitos(@PathParam("id") int id){
        try{
            List<ModelDesafioAceito> lista = serviceDesafioUsuario.listarDesafiosAceitos(id);
            return Response.status(Response.Status.OK)
                    .entity(lista).build();

        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro com a base de dados" + e).build();
        } catch (NotFoundException e){
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage()).build();
        }
    }

    @Path("/stats/{id}")
    @GET
    public Response stats(@PathParam("id") int id){
        try{
            ModelStatus stats = serviceDesafioUsuario.retornaStats(id);
            return Response.status(Response.Status.OK)
                    .entity(stats).build();

        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro com a base de dados" + e).build();
        }
    }



}
