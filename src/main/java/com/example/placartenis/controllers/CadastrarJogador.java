package com.example.placartenis.controllers;

import com.example.placartenis.dominio.Jogador;
import com.example.placartenis.exception.JogadorException;
import com.example.placartenis.request.JogadorRequest;
import com.example.placartenis.repositories.JogadorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/placartenis")
public class CadastrarJogador {
    private final JogadorRepository jogadorRepository;

    public CadastrarJogador(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    @GetMapping("/jogador")
    public List<Jogador> listarTodos() {
        final var jogadores = jogadorRepository.findAll();
        if (jogadores.isEmpty()) {
            throw new JogadorException("Sem jogadores cadastrados");
        }
        return jogadores;
    }

    @DeleteMapping("/jogador/{id}")
    public void deletarPor(@PathVariable(value = "id") Long id) {
        jogadorRepository.findById(id)
                .orElseThrow(() -> new JogadorException("Jogador " + id + " nao existe."));
        jogadorRepository.deleteById(id);
    }


    @GetMapping("/jogador/{id}")
    public Jogador buscarPor(@PathVariable(value = "id") Long id) {
        return jogadorRepository.findById(id)
                .orElseThrow(() -> new JogadorException("Jogador " + id + " nao encontrado."));
    }

    @PostMapping("/jogadornovo")
    public Jogador cadastrarJogador(@RequestBody JogadorRequest jogadorRequest) {
        Jogador novoJogador = new Jogador(
                jogadorRequest.nomeJogador(),
                jogadorRequest.vitoria()

        );
        return jogadorRepository.save(novoJogador);
    }
}
