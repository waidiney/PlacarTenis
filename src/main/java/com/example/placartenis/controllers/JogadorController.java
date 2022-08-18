package com.example.placartenis.controllers;

import com.example.placartenis.controllers.request.JogadorRequest;
import com.example.placartenis.dominio.Jogador;
import com.example.placartenis.repositories.JogadorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/placar/")
public class JogadorController {

    private final JogadorRepository jogadorRepository;

    public JogadorController(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    @PostMapping("/novoJogador")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarJogador(@RequestBody JogadorRequest request) {
        final var novoJogador = new Jogador(
                request.nomeJogador(),
                0L
        );
        jogadorRepository.save(novoJogador);
    }

    @GetMapping("/jogador")
    public List<Jogador> listarTodos(){
        final var jogadores = jogadorRepository.findAll();
        if (jogadores.isEmpty()){
            throw new RuntimeException("Sem jogadores cadastrados");
        }
        return jogadores;

    }
}
