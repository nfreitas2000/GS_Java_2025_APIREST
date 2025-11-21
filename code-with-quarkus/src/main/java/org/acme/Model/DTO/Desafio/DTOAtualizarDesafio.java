package org.acme.Model.DTO.Desafio;

public class DTOAtualizarDesafio {
    private int id_desafio;
    private String categoria;
    private String titulo;
    private String descricao;
    private int xp_recompensa;
    private String dificuldade;
    private String ativo;

    public DTOAtualizarDesafio(int id_desafio, String categoria, String titulo, String descricao, int xp_recompensa, String dificuldade, String ativo) {
        this.id_desafio = id_desafio;
        this.categoria = categoria;
        this.titulo = titulo;
        this.descricao = descricao;
        this.xp_recompensa = xp_recompensa;
        this.dificuldade = dificuldade;
        this.ativo = ativo;
    }

    public int getId_desafio() {
        return id_desafio;
    }

    public void setId_desafio(int id_desafio) {
        this.id_desafio = id_desafio;
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

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
}
