package org.acme.Model.DTO.Empresa;

public class DTOEmpresaNome {
    private String nome_empresa;

    public DTOEmpresaNome(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }
}
