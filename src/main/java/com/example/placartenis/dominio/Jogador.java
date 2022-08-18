package com.example.placartenis.dominio;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "jogador_placar")
public class Jogador implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codJogador", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codJogador;
    @Column
    private String nome;
    @Column
    private Long vitorias;

    public Jogador() {
    }

    public Jogador(Long codJogador, String nome, Long vitorias) {
        this.codJogador = codJogador;
        this.nome = nome;
        this.vitorias = vitorias;
    }

    public Jogador(String nome, Long vitorias) {
        this.nome = nome;
        this.vitorias = vitorias;
    }

    public Jogador(Long codJogador) {
        this.codJogador = codJogador;
    }

    public Long getCodJogador() {
        return codJogador;
    }

    public String getNome() {
        return nome;
    }

    public Long getVitorias() {
        return vitorias;
    }
}
