package com.example.placartenis.controllers;

import com.example.placartenis.controllers.request.PartidaJogador;
import com.example.placartenis.controllers.response.ConfrontoResponse;
import com.example.placartenis.dominio.Partida;
import com.example.placartenis.services.PartidaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/placar/")
public class PartidaController {

    private final PartidaService partidaService;

    public PartidaController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }

    @PostMapping("/novaPartida")
    public Partida novaPartida(@RequestBody PartidaJogador partidaJogador){
        return partidaService.nova(partidaJogador);
    }

    @GetMapping("/confronto/listar")
    public List<ConfrontoResponse> listarConfronto(){
        return partidaService.listarConfronto();
    }

}
