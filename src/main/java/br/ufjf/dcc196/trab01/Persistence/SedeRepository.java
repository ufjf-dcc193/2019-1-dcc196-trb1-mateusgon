package br.ufjf.dcc196.trab01.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ufjf.dcc196.trab01.Models.Sede;

public interface SedeRepository extends JpaRepository<Sede, Long>{

    
}