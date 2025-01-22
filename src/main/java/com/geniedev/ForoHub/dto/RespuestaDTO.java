package com.geniedev.ForoHub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RespuestaDTO(
        Long id,

        @NotBlank(message = "El mensaje de la respuesta es obligatorio")
        String mensaje,

        LocalDateTime fechaCreacion,

        @NotNull(message = "El ID del autor es obligatorio")
        Long autorId,

        @NotNull(message = "El ID del tópico es obligatorio")
        Long topicoId,

        Boolean solucion
) {}
