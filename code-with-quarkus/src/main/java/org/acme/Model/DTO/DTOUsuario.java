package org.acme.Model.DTO;

import org.acme.Model.ModelEmpresa;

public class DTOUsuario {
    private String nome_usuario;
    private String email;
    private String senha;
    private String nm_empresa;

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

    public String getNm_empresa() {
        return nm_empresa;
    }

    public void setNm_empresa(String nm_empresa) {
        this.nm_empresa = nm_empresa;
    }

    public DTOUsuario(String nome_usuario, String email, String senha, String nm_empresa) {
        this.nome_usuario = nome_usuario;
        this.email = email;
        this.senha = senha;
        this.nm_empresa = nm_empresa;
    }
}
