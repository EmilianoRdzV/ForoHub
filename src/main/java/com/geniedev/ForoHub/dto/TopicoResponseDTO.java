package com.geniedev.ForoHub.dto;

import java.time.LocalDateTime;

public record TopicoResponseDTO(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String autorNombre,
        String cursoNombre
) {}
