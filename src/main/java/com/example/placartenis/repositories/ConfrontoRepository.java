package com.example.placartenis.repositories;

import com.example.placartenis.dominio.Confronto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfrontoRepository extends JpaRepository<Confronto, Long> {
}
