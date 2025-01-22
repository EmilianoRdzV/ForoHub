package com.geniedev.ForoHub.services;

import com.geniedev.ForoHub.models.Curso;
import com.geniedev.ForoHub.repositories.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso crearCurso(Curso curso) {
        if (cursoRepository.existsByNombre(curso.getNombre())) {
            throw new RuntimeException("El curso ya existe");
        }
        return cursoRepository.save(curso);
    }

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }
}