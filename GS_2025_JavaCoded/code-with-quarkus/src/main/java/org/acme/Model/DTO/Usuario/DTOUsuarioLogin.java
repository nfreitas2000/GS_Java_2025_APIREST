package org.acme.Model.DTO.Usuario;

public class DTOUsuarioLogin {
    private String email_login_usuario;
    private String senha_login_usuario;

    public DTOUsuarioLogin(String email_login_usuario, String senha_login_usuario) {
        this.email_login_usuario = email_login_usuario;
        this.senha_login_usuario = senha_login_usuario;
    }

    public String getEmail_login_usuario() {
        return email_login_usuario;
    }

    public void setEmail_login_usuario(String email_login_usuario) {
        this.email_login_usuario = email_login_usuario;
    }

    public String getSenha_login_usuario() {
        return senha_login_usuario;
    }

    public void setSenha_login_usuario(String senha_login_usuario) {
        this.senha_login_usuario = senha_login_usuario;
    }
}
