package com.example.placartenis.services;

import com.example.placartenis.controllers.request.ConfrontoJogador;
import com.example.placartenis.controllers.response.ConfrontoResponse;
import com.example.placartenis.dominio.Confronto;
import com.example.placartenis.repositories.JogadorRepository;
import com.example.placartenis.repositories.ConfrontoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConfrontoService {
    private final ConfrontoRepository confrontoRepository;
    private final JogadorRepository jogadorRepository;

    public ConfrontoService(ConfrontoRepository confrontoRepository, JogadorRepository jogadorRepository) {
        this.confrontoRepository = confrontoRepository;
        this.jogadorRepository = jogadorRepository;
    }


    public Confronto nova(ConfrontoJogador confrontoJogador) {
        final var idJogador1 = jogadorRepository
                .findById(confrontoJogador.idJogador1())
                .orElseThrow(() -> new RuntimeException("Jogador nao encontrado"));

        final var idJogador2 = jogadorRepository
                .findById(confrontoJogador.idJogador2())
                .orElseThrow(() -> new RuntimeException("Jogador nao encontrado"));

        final var novaPartida = new Confronto(
               idJogador1.getCodJogador(),
                confrontoJogador.pontosJogador1(),
                idJogador2.getCodJogador(),
                confrontoJogador.pontosJogador2()
        );

        return confrontoRepository.save(novaPartida);

    }

    public List<ConfrontoResponse> listarConfronto() {
        final var listaConfronto = confrontoRepository.findAll();
        List<ConfrontoResponse> confrontoResponses = new ArrayList<>();
        listaConfronto.forEach(confronto -> {
            final var nomeJogador1 = jogadorRepository
                    .findByCodJogador(confronto.getIdJogador1());

            final var nomeJogador2= jogadorRepository
                    .findByCodJogador(confronto.getIdJogador2());
            final var vitoriaDe = jogadorRepository
                    .findByCodJogador(confronto.getVitoriaJogador());

            confrontoResponses.add(new ConfrontoResponse(
                    confronto.getIdConfronto(),
                    confronto.getDataPartida().toString(),
                    confronto.getIdJogador1(),
                    nomeJogador1.getNome(),
                    confronto.getPontosJogador1(),
                    confronto.getIdJogador2(),
                    nomeJogador2.getNome(),
                    confronto.getPontosJogador2(),
                    vitoriaDe.getNome()
            ));
        });

        return confrontoResponses;
    }
}
