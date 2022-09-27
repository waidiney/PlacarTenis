package com.example.placartenis.service;

import com.example.placartenis.dominio.Jogador;
import com.example.placartenis.exception.JogadorException;
import com.example.placartenis.repositories.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogadorService {
    @Autowired
    private JogadorRepository jogadorRepository;

    public Jogador findById(Long id) {
        return jogadorRepository.findById(id).orElseThrow(
                () -> new JogadorException("Jogador nao encontrado" + id));
    }
}
