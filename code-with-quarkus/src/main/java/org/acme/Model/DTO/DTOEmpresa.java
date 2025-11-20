package org.acme.Model.DTO;

public class DTOEmpresa {
    private String nome_empresa;
    private String cnpj;
    private String setor;
    private String data_criacao;

    public DTOEmpresa(String nome_empresa, String cnpj, String setor, String data_criacao) {
        this.nome_empresa = nome_empresa;
        this.cnpj = cnpj;
        this.setor = setor;
        this.data_criacao = data_criacao;
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
