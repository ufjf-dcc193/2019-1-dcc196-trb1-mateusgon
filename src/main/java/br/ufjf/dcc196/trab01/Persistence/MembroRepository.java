package br.ufjf.dcc196.trab01.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufjf.dcc196.trab01.Models.Membro;

public interface MembroRepository extends JpaRepository<Membro, Long>{

}