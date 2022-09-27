package com.example.placartenis.repositories;

import com.example.placartenis.dominio.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador,Long>{

}
