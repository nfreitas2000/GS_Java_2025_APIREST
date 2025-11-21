package org.acme.Resource.Desafio;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Model.DTO.Desafio.DTOAtualizarDesafio;
import org.acme.Model.DTO.Desafio.DTODesafio;
import org.acme.Model.DTO.Empresa.DTOEmpresa;
import org.acme.Model.ModelDesafio;
import org.acme.Service.Desafio.ServiceDesafios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Path("/desafio")
@Consumes(MediaType.APPLICATION_JSON)
public class ResourceDesafio {
    @Inject
    ServiceDesafios serviceDesafios;

    @Path("/criar")
    @POST
    public Response cadastrarDesafio(DTODesafio desafio){
        try{
            serviceDesafios.inserirDesafios(desafio);
            return Response.status(Response.Status.CREATED)
                    .entity("Criado com Sucesso").build();

        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR) /*500*/
                    .entity("Erro com a base de dados" + e).build();
        }
        catch (IllegalArgumentException e) {
            return Response.status(422).entity(e.getMessage()).build();
        }
    }

    @Path("/empresa/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response readDesafiosEmpresa(@PathParam("id")int id){
        try{
            List<ModelDesafio> lista = serviceDesafios.desafiosEmpresa(id);
            return Response.status(Response.Status.OK)
                    .entity(lista).build();

        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR) /*500*/
                    .entity("Erro com a base de dados" + e).build();
        }
    }

    @Path("/atualizar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarDesafiosEmpresa(DTOAtualizarDesafio desafio){
        try{
            serviceDesafios.updateDesafio(desafio);
            return Response.status(Response.Status.OK)
                    .entity("Atualizado com sucesso!").build();

        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR) /*500*/
                    .entity("Erro com a base de dados" + e).build();
        } catch (IllegalArgumentException e){
            return Response.status(422).entity(e.getMessage()).build();
        }
        catch (NotFoundException e){
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @Path("/deletar/{id}")
    @DELETE
    public Response deletarDesafios(@PathParam("id") int id){
        try{
            serviceDesafios.deletarDesafio(id);
            return Response.status(Response.Status.OK)
                    .entity("Deletado com sucesso!").build();

        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro com a base de dados" + e).build();
        }catch (IllegalArgumentException e){
            return Response.status(422).entity(e.getMessage()).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
}
