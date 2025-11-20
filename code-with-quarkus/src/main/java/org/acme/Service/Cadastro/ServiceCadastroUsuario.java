package org.acme.Service.Cadastro;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTO.DTOUsuario;
import org.acme.Repository.Cadastro.RepositoryCadastroUsuario;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class ServiceCadastroUsuario {
    @Inject
    RepositoryCadastroUsuario repositoryCadastroUsuario;

    public List<String> listaEmpresas() throws SQLException {
        return repositoryCadastroUsuario.listaNomeEmpresas();
    }

    public void inserir(DTOUsuario usuario) throws SQLException {
        if (usuario.getNome_usuario().isEmpty() || usuario.getEmail().isEmpty() || usuario.getSenha().isEmpty() || usuario.getNm_empresa().isEmpty()){
            throw new IllegalArgumentException("Campo vazio identificado");
        }
        repositoryCadastroUsuario.cadastarUsuario(usuario);
    }
}
