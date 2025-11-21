package org.acme.Model.DTO.Desafio;

public class DTODesafio {
    private int id_empresa;
    private String categoria;
    private String titulo;
    private String descricao;
    private int xp_recompensa;
    private String dificuldade;

    public DTODesafio(int id_empresa, String categoria, String titulo, String descricao, int xp_recompensa, String dificuldade) {
        this.id_empresa = id_empresa;
        this.categoria = categoria;
        this.titulo = titulo;
        this.descricao = descricao;
        this.xp_recompensa = xp_recompensa;
        this.dificuldade = dificuldade;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getXp_recompensa() {
        return xp_recompensa;
    }

    public void setXp_recompensa(int xp_recompensa) {
        this.xp_recompensa = xp_recompensa;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }
}
