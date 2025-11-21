package org.acme.Model.DTO.Empresa;

public class DTOEmpresaLogin {
    private String email_login_empresa;
    private String senha_login_empresa;

    public DTOEmpresaLogin(String email_login_empresa, String senha_login_empresa) {
        this.email_login_empresa = email_login_empresa;
        this.senha_login_empresa = senha_login_empresa;
    }

    public String getEmail_login_empresa() {
        return email_login_empresa;
    }

    public void setEmail_login_empresa(String email_login_empresa) {
        this.email_login_empresa = email_login_empresa;
    }

    public String getSenha_login_empresa() {
        return senha_login_empresa;
    }

    public void setSenha_login_empresa(String senha_login_empresa) {
        this.senha_login_empresa = senha_login_empresa;
    }
}
