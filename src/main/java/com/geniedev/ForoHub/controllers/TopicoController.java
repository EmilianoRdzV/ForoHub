package com.geniedev.ForoHub.controllers;

import com.geniedev.ForoHub.dto.TopicoRequestDTO;
import com.geniedev.ForoHub.models.Topico;
import com.geniedev.ForoHub.models.Usuario;
import com.geniedev.ForoHub.models.Curso;
import com.geniedev.ForoHub.repositories.TopicoRepository;
import com.geniedev.ForoHub.repositories.UsuarioRepository;
import com.geniedev.ForoHub.repositories.CursoRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    public TopicoController(TopicoRepository topicoRepository, UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }

    @PostMapping
    public ResponseEntity<String> registrarTopico(@RequestBody @Valid TopicoRequestDTO dto) {
        if (topicoRepository.existsByTituloAndMensaje(dto.titulo(), dto.mensaje())) {
            return ResponseEntity.badRequest().body("Tópico duplicado");
        }

        Usuario autor = usuarioRepository.findById(dto.autorId())
                .orElseThrow(() -> new RuntimeException("El autor no existe"));

        Curso curso = cursoRepository.findById(dto.cursoId())
                .orElseThrow(() -> new RuntimeException("El curso no existe"));

        Topico topico = new Topico(dto.titulo(), dto.mensaje(), LocalDateTime.now(), autor, curso);

        topicoRepository.save(topico);

        return ResponseEntity.ok("Tópico creado con éxito");
    }

    @GetMapping
    public ResponseEntity<List<Topico>> listarTopicos() {
        return ResponseEntity.ok(topicoRepository.findAll());
    }
}