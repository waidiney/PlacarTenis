package com.example.placartenis.controllers;

import com.example.placartenis.controllers.request.JogadorRequest;
import com.example.placartenis.dominio.Jogador;
import com.example.placartenis.repositories.JogadorRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/placartenis")
public class CadastrarJogador {
    private final JogadorRepository jogadorRepository;

    public CadastrarJogador(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    @GetMapping("/nome")
    public String nome(){
        return "joao";
    }

    @PostMapping("/jogadornovo")
    public Jogador cadastrarJogador(@RequestBody JogadorRequest jogadorRequest){
        Jogador novoJogador = new Jogador(
                jogadorRequest.nomeJogador(),
                jogadorRequest.vitoria()

        );
        return jogadorRepository.save(novoJogador);
    }
}
