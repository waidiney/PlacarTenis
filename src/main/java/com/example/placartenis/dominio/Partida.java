package com.example.placartenis.dominio;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "partida_placar")
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPartida;

    @Column
    private LocalDate dataPartida;

    @Column
    private Long idJogador1;

    @Column
    private Long idJogador2;

    @Column
    private Long vitoriaJogador;

    public Partida() {
    }

    public Partida(Long idPartida, LocalDate dataPartida, Long idJogador1, Long idJogador2, Long vitoriaJogador) {
        this.idPartida = idPartida;
        this.dataPartida = dataPartida;
        this.idJogador1 = idJogador1;
        this.idJogador2 = idJogador2;
        this.vitoriaJogador = vitoriaJogador;
    }

    public Partida(Long idJogador1, Long idJogador2, Long vitoriaJogador) {
        this.dataPartida = LocalDate.now();
        this.idJogador1 = idJogador1;
        this.idJogador2 = idJogador2;
        this.vitoriaJogador = vitoriaJogador;
    }


    public Long getIdPartida() {
        return idPartida;
    }

    public LocalDate getDataPartida() {
        return dataPartida;
    }

    public Long getIdJogador1() {
        return idJogador1;
    }

    public Long getIdJogador2() {
        return idJogador2;
    }

    public Long getVitoriaJogador() {
        return vitoriaJogador;
    }
}
