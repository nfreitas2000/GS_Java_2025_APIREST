package org.acme.Model;

public class ModelUsuario {
    private int id_usuario;
    private String nome_usuario;
    private String email;
    private String senha;
    private String data_cadastro;
    private String ativo;
    private ModelEmpresa empresa;

    public ModelUsuario(int id_usuario, String nome_usuario, String email, String senha, String data_cadastro, String ativo, ModelEmpresa empresa) {
        this.id_usuario = id_usuario;
        this.nome_usuario = nome_usuario;
        this.email = email;
        this.senha = senha;
        this.data_cadastro = data_cadastro;
        this.ativo = ativo;
        this.empresa = empresa;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public ModelEmpresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(ModelEmpresa empresa) {
        this.empresa = empresa;
    }
}
