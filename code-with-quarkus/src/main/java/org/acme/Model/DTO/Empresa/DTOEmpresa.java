package org.acme.Model.DTO.Empresa;

public class DTOEmpresa {
    private String nome_empresa;
    private String cnpj;
    private String setor;
    private String data_criacao;
    private String email_corporativo;
    private String senha_corporativa;

    public DTOEmpresa(String nome_empresa, String cnpj, String setor, String data_criacao, String email_corporativo, String senha_corporativa) {
        this.nome_empresa = nome_empresa;
        this.cnpj = cnpj;
        this.setor = setor;
        this.data_criacao = data_criacao;
        this.email_corporativo = email_corporativo;
        this.senha_corporativa = senha_corporativa;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public String getEmail_coporativo() {
        return email_corporativo;
    }

    public void setEmail_coporativo(String email_coporativo) {
        this.email_corporativo = email_coporativo;
    }

    public String getSenha_coporativa() {
        return senha_corporativa;
    }

    public void setSenha_coporativa(String senha_coporativa) {
        this.senha_corporativa = senha_coporativa;
    }

    public String getNome() {
        return nome_empresa;
    }

    public void setNome(String nome) {
        this.nome_empresa = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(String data_criacao) {
        this.data_criacao = data_criacao;
    }
}
