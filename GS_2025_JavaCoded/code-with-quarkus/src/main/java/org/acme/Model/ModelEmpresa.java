package org.acme.Model;

public class ModelEmpresa {
    private int id_empresa;
    private String nome;
    private String cnpj;
    private String setor;
    private String data_criacao;

    public ModelEmpresa(int id_empresa, String nome, String cnpj, String setor, String data_criacao) {
        this.id_empresa = id_empresa;
        this.nome = nome;
        this.cnpj = cnpj;
        this.setor = setor;
        this.data_criacao = data_criacao;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
