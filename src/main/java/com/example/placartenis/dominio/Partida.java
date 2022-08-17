package com.example.placartenis.dominio;

public class Partida {
    private String Jogador1;
    private String Jogador2;

    public Partida(String jogador1, String jogador2) {
        Jogador1 = jogador1;
        Jogador2 = jogador2;
    }

    public String getJogador1() {
        return Jogador1;
    }

    public void setJogador1(String jogador1) {
        Jogador1 = jogador1;
    }

    public String getJogador2() {
        return Jogador2;
    }

    public void setJogador2(String jogador2) {
        Jogador2 = jogador2;
    }
}
