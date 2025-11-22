package org.acme.Service.Desafio;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.acme.Model.ModelDesafio;
import org.acme.Model.ModelDesafioAceito;
import org.acme.Model.ModelStatus;
import org.acme.Repository.Desafios.RepositoryDesafiosUsuario;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class ServiceDesafioUsuario {
    @Inject
    RepositoryDesafiosUsuario repositoryDesafiosUsuario;

    public List<ModelDesafio> desafiosUsuarioEmpresa(int id_usuario) throws SQLException, NotFoundException {
        List<ModelDesafio> listaDesafios = repositoryDesafiosUsuario.readDesafiosUsuarioEmpresa(id_usuario);
        if (listaDesafios.isEmpty()){
            throw new NotFoundException("Nenhum desafio encontrado!");
        }
        return listaDesafios;
    }

    public void aceitarDesafio(int id_usuario, int id_desafio) throws SQLException {
        if (id_usuario <= 0 || id_desafio <= 0) {
            throw new IllegalArgumentException("ID menor ou igual a 0");
        }
        repositoryDesafiosUsuario.aceitarDesafio(id_usuario, id_desafio);
    }

    public void finalizarDesafio(int id_usuario, int id_desafio) throws SQLException {
        if (id_usuario <= 0 || id_desafio <= 0) {
            throw new IllegalArgumentException("ID menor ou igual a 0");
        }
        repositoryDesafiosUsuario.concluirDesafio(id_usuario, id_desafio);
    }

    public List<ModelDesafioAceito> listarDesafiosAceitos(int id_usuario) throws SQLException {
        List<ModelDesafioAceito> lista = repositoryDesafiosUsuario.listarDesafiosAceitos(id_usuario);
        if (lista.isEmpty()){
            throw new NotFoundException("Nenhum desafio aceito!");
        }
        return lista;
    }

    public ModelStatus retornaStats (int id) throws SQLException {
        ModelStatus stats = repositoryDesafiosUsuario.recuperarStatus(id);
        if (stats == null){
            throw new SQLException("Usuário não encontrado");
        }
        return stats;
    }
}
