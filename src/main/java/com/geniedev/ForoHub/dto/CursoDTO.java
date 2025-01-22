package com.geniedev.ForoHub.dto;

import jakarta.validation.constraints.NotBlank;

public record CursoDTO(
        Long id,

        @NotBlank(message = "El nombre del curso es obligatorio")
        String nombre,

        @NotBlank(message = "La categoría es obligatoria")
        String categoria
) {}
