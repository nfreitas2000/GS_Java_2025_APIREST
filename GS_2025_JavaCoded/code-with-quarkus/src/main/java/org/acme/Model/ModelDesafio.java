package org.acme.Model;

public class ModelDesafio {
    private int id_desafio;
    private int id_empresa;
    private String categoria;
    private String titulo;
    private String descricao;
    private int xp_recompensa;
    private String dificuldade;
    private String data_criacao;
    private String ativo;

    public ModelDesafio(int id_desafio, int id_empresa, String categoria, String titulo, String descricao, int xp_recompensa, String dificuldade, String data_criacao, String ativo) {
        this.id_desafio = id_desafio;
        this.id_empresa = id_empresa;
        this.categoria = categoria;
        this.titulo = titulo;
        this.descricao = descricao;
        this.xp_recompensa = xp_recompensa;
        this.dificuldade = dificuldade;
        this.data_criacao = data_criacao;
        this.ativo = ativo;
    }

    public int getId_desafio() {
        return id_desafio;
    }

    public void setId_desafio(int id_desafio) {
        this.id_desafio = id_desafio;
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

    public String getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(String data_criacao) {
        this.data_criacao = data_criacao;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
}
