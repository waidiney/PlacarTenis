package com.example.placartenis.dominio;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "partida_confronto")
public class Confronto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConfronto;

    @Column
    private LocalDate dataPartida;

    @Column
    private Long idJogador1;
    @Column
    private Long pontosJogador1;

    @Column
    private Long idJogador2;

    @Column
    private Long pontosJogador2;

    @Column
    private Long vitoriaJogador;

    public Confronto() {
    }

    public Confronto(Long idConfronto, LocalDate dataPartida, Long idJogador1, Long idJogador2, Long vitoriaJogador) {
        this.idConfronto = idConfronto;
        this.dataPartida = dataPartida;
        this.idJogador1 = idJogador1;
        this.idJogador2 = idJogador2;
        this.vitoriaJogador = vitoriaJogador;
    }

    public Confronto(Long idJogador1, Long idJogador2, Long vitoriaJogador) {
        this.dataPartida = LocalDate.now();
        this.idJogador1 = idJogador1;
        this.idJogador2 = idJogador2;
        this.vitoriaJogador = vitoriaJogador;
    }

    public Confronto(Long idJogador1, Long pontosJogador1, Long idJogador2, Long pontosJogador2, Long vitoriaJogador) {
        this.dataPartida = LocalDate.now();
        this.idJogador1 = idJogador1;
        this.pontosJogador1 = pontosJogador1;
        this.idJogador2 = idJogador2;
        this.pontosJogador2 = pontosJogador2;
        this.vitoriaJogador = vitoriaJogador;
    }

    public Confronto(Long idJogador1, Long pontosJogador1, Long idJogador2, Long pontosJogador2) {
        this.dataPartida = LocalDate.now();
        this.idJogador1 = idJogador1;
        this.pontosJogador1 = pontosJogador1;
        this.idJogador2 = idJogador2;
        this.pontosJogador2 = pontosJogador2;
    }

    public Long getIdConfronto() {
        return idConfronto;
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
        if(getPontosJogador1() > getPontosJogador2()){
            return vitoriaJogador = getIdJogador1();
        }
        return vitoriaJogador = getIdJogador2();
    }

    public Long getPontosJogador1() {
        return pontosJogador1;
    }

    public Long getPontosJogador2() {
        return pontosJogador2;
    }
}
