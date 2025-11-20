package org.acme.Service.Cadastro;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTO.DTOEmpresa;
import org.acme.Repository.Cadastro.RepositoryCadastroEmpresa;

import java.sql.SQLException;

@ApplicationScoped
public class ServiceCadastroEmpresa {
    @Inject
    RepositoryCadastroEmpresa repositoryCadastroEmpresa;

    public boolean verificacao(DTOEmpresa empresa) {
        if (empresa.getNome().isEmpty() || empresa.getCnpj().isEmpty() || empresa.getSetor().isEmpty() || empresa.getData_criacao().isEmpty()){
            throw new IllegalArgumentException("Campo vazio identificado!");
        }
        if (empresa.getCnpj().length() != 14){
            throw new IllegalArgumentException("CNPJ inválido");
        }
        return true;
    }

    public DTOEmpresa formatacao(DTOEmpresa empresa) {
        empresa.setCnpj(
                        empresa.getCnpj().substring(0, 2) + "." +
                        empresa.getCnpj().substring(2, 5) + "." +
                        empresa.getCnpj().substring(5, 8) + "/" +
                        empresa.getCnpj().substring(8, 12) + "-" +
                        empresa.getCnpj().substring(12)
        );
        empresa.setNome(empresa.getNome().strip());
        empresa.setSetor(empresa.getSetor().strip());
        empresa.setSetor(empresa.getData_criacao().strip());
        return empresa;
    }

    public void inserir(DTOEmpresa empresa) throws SQLException {
        if (verificacao(empresa)){
            repositoryCadastroEmpresa.inserirEmpresa(empresa);
        }
    }
}
