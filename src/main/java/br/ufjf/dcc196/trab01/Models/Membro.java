package br.ufjf.dcc196.trab01.Models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.crypto.Data;

import org.springframework.format.annotation.DateTimeFormat;

public class Membro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String funcao;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Data dataDeEntrada = null;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Data dataDeSaida = null;
    @ManyToOne
    @JoinColumn
    private Sede sede;

}