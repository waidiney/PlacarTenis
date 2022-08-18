package com.example.placartenis.services;

import com.example.placartenis.controllers.request.PartidaJogador;
import com.example.placartenis.controllers.response.ConfrontoResponse;
import com.example.placartenis.dominio.Partida;
import com.example.placartenis.repositories.JogadorRepository;
import com.example.placartenis.repositories.PartidaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartidaService {
    private final PartidaRepository partidaRepository;
    private final JogadorRepository jogadorRepository;

    public PartidaService(PartidaRepository partidaRepository, JogadorRepository jogadorRepository) {
        this.partidaRepository = partidaRepository;
        this.jogadorRepository = jogadorRepository;
    }


    public Partida nova(PartidaJogador partidaJogador) {
        final var idJogador1 = jogadorRepository
                .findById(partidaJogador.idJogador1())
                .orElseThrow(() -> new RuntimeException("Jogador nao encontrado"));

        final var idJogador2 = jogadorRepository
                .findById(partidaJogador.idJogador2())
                .orElseThrow(() -> new RuntimeException("Jogador nao encontrado"));

        final var novaPartida = new Partida(
               idJogador1.getCodJogador(),
                idJogador2.getCodJogador(),
                partidaJogador.vitoriaJogador()
        );

        return partidaRepository.save(novaPartida);

    }

    public List<ConfrontoResponse> listarConfronto() {
        final var listaConfronto = partidaRepository.findAll();
        List<ConfrontoResponse> confrontoResponses = new ArrayList<>();
        listaConfronto.forEach(confronto -> {
            final var nomeJogador1 = jogadorRepository
                    .findByCodJogador(confronto.getIdJogador1());

            final var nomeJogador2= jogadorRepository
                    .findByCodJogador(confronto.getIdJogador2());
            final var vitoriaDe = jogadorRepository
                    .findByCodJogador(confronto.getVitoriaJogador());

            confrontoResponses.add(new ConfrontoResponse(
                    confronto.getIdPartida(),
                    confronto.getDataPartida().toString(),
                    confronto.getIdJogador1(),
                    nomeJogador1.getNome(),
                    confronto.getIdJogador2(),
                    nomeJogador2.getNome(),
                    vitoriaDe.getNome()
            ));
        });

        return confrontoResponses;
    }
}
