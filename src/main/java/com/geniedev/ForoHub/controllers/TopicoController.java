package com.geniedev.ForoHub.controllers;

import com.geniedev.ForoHub.dto.TopicoRequestDTO;
import com.geniedev.ForoHub.models.Topico;
import com.geniedev.ForoHub.repositories.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository topicoRepository;

    public TopicoController(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    @PostMapping
    public ResponseEntity<String> registrarTopico(@RequestBody @Valid TopicoRequestDTO dto) {
        if (topicoRepository.existsByTituloAndMensaje(dto.titulo(), dto.mensaje())) {
            return ResponseEntity.badRequest().body("Tópico duplicado");
        }

        Topico topico = new Topico(null, dto.titulo(), dto.mensaje(), null, dto.autorId(), dto.cursoId());
        topicoRepository.save(topico);
        return ResponseEntity.ok("Tópico creado con éxito");
    }

    @GetMapping
    public ResponseEntity<List<Topico>> listarTopicos() {
        return ResponseEntity.ok(topicoRepository.findAll());
    }
}
