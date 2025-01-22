package com.geniedev.ForoHub.services;

import com.geniedev.ForoHub.dto.TopicoRequestDTO;
import com.geniedev.ForoHub.dto.TopicoResponseDTO;
import com.geniedev.ForoHub.models.Curso;
import com.geniedev.ForoHub.models.Topico;
import com.geniedev.ForoHub.models.Usuario;
import com.geniedev.ForoHub.repositories.CursoRepository;
import com.geniedev.ForoHub.repositories.TopicoRepository;
import com.geniedev.ForoHub.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

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

    public TopicoResponseDTO crearTopico(TopicoRequestDTO dto) {
        Usuario autor = usuarioRepository.findById(dto.autorId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        Curso curso = cursoRepository.findById(dto.cursoId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Topico topico = new Topico(null, dto.titulo(), dto.mensaje(), null, autor, curso);
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
}
