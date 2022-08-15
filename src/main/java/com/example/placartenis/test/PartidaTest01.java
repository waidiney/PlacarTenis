package com.example.placartenis.test;
import com.example.placartenis.dominio.Partida;

public class PartidaTest01 {
    public static void main(String[] args) {
        Partida partida = new Partida("Away");
        String [] jogadores = new String[2];
        jogadores[0] = "Jogador 1";
        jogadores[1] = "Jogador 2";
        System.out.println(jogadores[0]);
        System.out.println(jogadores[1]);

    }
}
