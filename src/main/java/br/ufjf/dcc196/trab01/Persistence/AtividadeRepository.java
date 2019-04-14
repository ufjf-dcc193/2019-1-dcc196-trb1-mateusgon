package br.ufjf.dcc196.trab01.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufjf.dcc196.trab01.Models.Atividade;

public interface AtividadeRepository extends JpaRepository<Atividade, Long>{

    
}