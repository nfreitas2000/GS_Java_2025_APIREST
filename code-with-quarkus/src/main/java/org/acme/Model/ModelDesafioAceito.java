package org.acme.Model;

public class ModelDesafioAceito {
    private int idParticipacao;
    private int idUsuario;
    private int idDesafio;
    private String status;
    private String dataInicio;
    private String dataConclusao;

    private String categoria;
    private String titulo;
    private String descricao;
    private int xpRecompensa;
    private String dificuldade;
    private String dataCriacao;
    private String ativo;

    public ModelDesafioAceito(int idParticipacao, int idUsuario, int idDesafio, String status, String dataInicio, String dataConclusao, String categoria, String titulo, String descricao, int xpRecompensa, String dificuldade, String dataCriacao, String ativo) {
        this.idParticipacao = idParticipacao;
        this.idUsuario = idUsuario;
        this.idDesafio = idDesafio;
        this.status = status;
        this.dataInicio = dataInicio;
        this.dataConclusao = dataConclusao;
        this.categoria = categoria;
        this.titulo = titulo;
        this.descricao = descricao;
        this.xpRecompensa = xpRecompensa;
        this.dificuldade = dificuldade;
        this.dataCriacao = dataCriacao;
        this.ativo = ativo;
    }

    public int getIdParticipacao() {
        return idParticipacao;
    }

    public void setIdParticipacao(int idParticipacao) {
        this.idParticipacao = idParticipacao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdDesafio() {
        return idDesafio;
    }

    public void setIdDesafio(int idDesafio) {
        this.idDesafio = idDesafio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(String dataConclusao) {
        this.dataConclusao = dataConclusao;
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

    public int getXpRecompensa() {
        return xpRecompensa;
    }

    public void setXpRecompensa(int xpRecompensa) {
        this.xpRecompensa = xpRecompensa;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
}
