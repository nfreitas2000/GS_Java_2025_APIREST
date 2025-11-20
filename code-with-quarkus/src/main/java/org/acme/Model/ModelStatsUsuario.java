package org.acme.Model;

public class ModelStatsUsuario {
    int id_status_usuario;
    int id_usuario;
    int desafios_concluidos;
    int nivel_atual;
    int xp_atual;
    int xp_total;

    public ModelStatsUsuario(int id_status_usuario, int id_usuario, int desafios_concluidos, int nivel_atual, int xp_atual, int xp_total) {
        this.id_status_usuario = id_status_usuario;
        this.id_usuario = id_usuario;
        this.desafios_concluidos = desafios_concluidos;
        this.nivel_atual = nivel_atual;
        this.xp_atual = xp_atual;
        this.xp_total = xp_total;
    }

    public int getId_status_usuario() {
        return id_status_usuario;
    }

    public void setId_status_usuario(int id_status_usuario) {
        this.id_status_usuario = id_status_usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getDesafios_concluidos() {
        return desafios_concluidos;
    }

    public void setDesafios_concluidos(int desafios_concluidos) {
        this.desafios_concluidos = desafios_concluidos;
    }

    public int getNivel_atual() {
        return nivel_atual;
    }

    public void setNivel_atual(int nivel_atual) {
        this.nivel_atual = nivel_atual;
    }

    public int getXp_atual() {
        return xp_atual;
    }

    public void setXp_atual(int xp_atual) {
        this.xp_atual = xp_atual;
    }

    public int getXp_total() {
        return xp_total;
    }

    public void setXp_total(int xp_total) {
        this.xp_total = xp_total;
    }
}
