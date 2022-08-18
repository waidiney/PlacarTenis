package com.example.placartenis.controllers;

import com.example.placartenis.controllers.request.ConfrontoJogador;
import com.example.placartenis.controllers.response.ConfrontoResponse;
import com.example.placartenis.dominio.Confronto;
import com.example.placartenis.services.ConfrontoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/placar/")
public class ConfrontoController {

    private final ConfrontoService confrontoService;

    public ConfrontoController(ConfrontoService confrontoService) {
        this.confrontoService = confrontoService;
    }

    @PostMapping("/novaPartida")
    public Confronto novaPartida(@RequestBody ConfrontoJogador confrontoJogador){
        return confrontoService.nova(confrontoJogador);
    }

    @GetMapping("/confronto/listar")
    public List<ConfrontoResponse> listarConfronto(){
        return confrontoService.listarConfronto();
    }

}
