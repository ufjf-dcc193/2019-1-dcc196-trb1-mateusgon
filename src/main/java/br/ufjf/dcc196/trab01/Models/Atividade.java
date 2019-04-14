package br.ufjf.dcc196.trab01.Models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String titulo;
    private String descricao;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataDeInicio = null;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataDeFim = null;
    @ManyToOne
    @JoinColumn
    private Sede sedeAtividade;

    public Atividade() {

    }

    public Atividade(String titulo, String descricao, Date dataDeInicio, Date dataDeFim) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataDeInicio = dataDeInicio;
        this.dataDeFim = dataDeFim;
    }

    /**
     * @return the dataDeFim
     */
    public Date getDataDeFim() {
        return dataDeFim;
    }

    /**
     * @return the dataDeInicio
     */
    public Date getDataDeInicio() {
        return dataDeInicio;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the sede
     */
    public Sede getSede() {
        return sedeAtividade;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param dataDeFim the dataDeFim to set
     */
    public void setDataDeFim(Date dataDeFim) {
        this.dataDeFim = dataDeFim;
    }

    /**
     * @param dataDeInicio the dataDeInicio to set
     */
    public void setDataDeInicio(Date dataDeInicio) {
        this.dataDeInicio = dataDeInicio;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @param sede the sede to set
     */
    public void setSede(Sede sede) {
        this.sedeAtividade = sede;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
}
