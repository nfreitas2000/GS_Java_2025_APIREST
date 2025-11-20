package org.acme.Service.Desafio;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTO.Desafio.DTODesafio;
import org.acme.Model.DTO.Empresa.DTOEmpresa;
import org.acme.Model.ModelDesafio;
import org.acme.Repository.Desafios.RepositoryDesafios;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class ServiceDesafios {
    @Inject
    RepositoryDesafios repositoryDesafios;

    public boolean verificacaoDesafio(DTODesafio desafio){
        if (desafio.getId_empresa() <= 0) {
            throw new IllegalArgumentException("ID da empresa inválido.");
        }
        if (desafio.getCategoria() == null || desafio.getCategoria().isEmpty()) {
            throw new IllegalArgumentException("Categoria não pode ser vazia.");
        }
        if (desafio.getTitulo() == null || desafio.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("Título não pode ser vazio.");
        }
        if (desafio.getDescricao() == null || desafio.getDescricao().isEmpty()) {
            throw new IllegalArgumentException("Descrição não pode ser vazia.");
        }
        if (desafio.getXp_recompensa() <= 0) {
            throw new IllegalArgumentException("XP de recompensa deve ser maior que zero.");
        }
        if (desafio.getDificuldade() == null || desafio.getDificuldade().isEmpty()) {
            throw new IllegalArgumentException("Dificuldade não pode ser vazia.");
        }
        return true;
    }

    public void inserirDesafios(DTODesafio desafio) throws SQLException {
        if (verificacaoDesafio(desafio)){
            repositoryDesafios.inserirDesafio(desafio);
        }
    }
    public List<ModelDesafio> desafiosEmpresa(int id_empresa) throws SQLException {
        return repositoryDesafios.readDesafiosCadastradosEmpresa(id_empresa);
    }
}
