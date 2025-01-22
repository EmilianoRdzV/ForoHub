package com.geniedev.ForoHub.services;

import com.geniedev.ForoHub.dto.*;
import com.geniedev.ForoHub.models.*;
import com.geniedev.ForoHub.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    public TopicoService(TopicoRepository topicoRepository, UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }

    @Transactional
    public TopicoResponseDTO crearTopico(TopicoRequestDTO dto) {
        Usuario autor = usuarioRepository.findById(dto.autorId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        Curso curso = cursoRepository.findById(dto.cursoId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Topico topico = new Topico(dto.titulo(), dto.mensaje(), LocalDateTime.now(), autor, curso);
        topicoRepository.save(topico);

        return new TopicoResponseDTO(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                autor.getNombre(),
                curso.getNombre()
        );
    }

    public List<TopicoResponseDTO> listarTopicos() {
        List<Topico> topicos = topicoRepository.findAll();
        return topicos.stream().map(t ->
                new TopicoResponseDTO(
                        t.getId(),
                        t.getTitulo(),
                        t.getMensaje(),
                        t.getFechaCreacion(),
                        t.getAutor().getNombre(),
                        t.getCurso().getNombre()
                )
        ).collect(Collectors.toList());
    }
}


