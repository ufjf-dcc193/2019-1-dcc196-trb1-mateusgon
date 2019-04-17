package br.ufjf.dcc196.trab01.Models;

public class Categoria {
    private String nome;
    private Double horas;
    private Integer numeroDeAtividades;

    public Categoria() {

    }

    public Categoria(String nome, Double horas, Integer numeroDeAtividades)
    {
        this.nome = nome;
        this.horas = horas;
        this.numeroDeAtividades = numeroDeAtividades;
    }

    /**
     * @param numeroDeAtividades the numeroDeAtividades to set
     */
    public void setNumeroDeAtividades(Integer numeroDeAtividades) {
        this.numeroDeAtividades = numeroDeAtividades;
    }

    /**
     * @return the numeroDeAtividades
     */
    public Integer getNumeroDeAtividades() {
        return numeroDeAtividades;
    }
    /**
     * @param horas the horas to set
     */
    public void setHoras(Double horas) {
        this.horas = horas;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the horas
     */
    public Double getHoras() {
        return horas;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }
}