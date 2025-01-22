package com.geniedev.ForoHub.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(
        Long id,

        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        @Email(message = "Debe ser un email válido")
        String correoElectronico
) {}
