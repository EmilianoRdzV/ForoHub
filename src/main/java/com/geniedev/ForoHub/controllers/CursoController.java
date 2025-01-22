package com.geniedev.ForoHub.controllers;

import com.geniedev.ForoHub.models.Curso;
import com.geniedev.ForoHub.repositories.CursoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoRepository cursoRepository;

    public CursoController(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @PostMapping
    public ResponseEntity<Curso> registrarCurso(@RequestBody Curso curso) {
        return ResponseEntity.ok(cursoRepository.save(curso));
    }

    @GetMapping
    public ResponseEntity<List<Curso>> listarCursos() {
        return ResponseEntity.ok(cursoRepository.findAll());
    }
}
