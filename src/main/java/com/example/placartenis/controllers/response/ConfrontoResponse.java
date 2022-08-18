package com.example.placartenis.controllers.response;

public record ConfrontoResponse(
        Long idConfronto,
        String dataPartida,
        Long idJogador1,
        String nomeJogador1,
        Long pontosJogador1,
        Long idJogador2,
        String nomeJogador2,
        Long pontosJogador2,
        String vitoriaDe
) {
}
