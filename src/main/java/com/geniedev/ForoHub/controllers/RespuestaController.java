package com.geniedev.ForoHub.controllers;

import com.geniedev.ForoHub.models.Respuesta;
import com.geniedev.ForoHub.repositories.RespuestaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    private final RespuestaRepository respuestaRepository;

    public RespuestaController(RespuestaRepository respuestaRepository) {
        this.respuestaRepository = respuestaRepository;
    }

    @PostMapping
    public ResponseEntity<Respuesta> registrarRespuesta(@RequestBody Respuesta respuesta) {
        return ResponseEntity.ok(respuestaRepository.save(respuesta));
    }

    @GetMapping
    public ResponseEntity<List<Respuesta>> listarRespuestas() {
        return ResponseEntity.ok(respuestaRepository.findAll());
    }
}
