package com.geniedev.ForoHub.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "topico", uniqueConstraints = { @UniqueConstraint(columnNames = { "titulo", "mensaje" }) })
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String mensaje;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    public Topico(String titulo, @NotBlank(message = "El mensaje es obligatorio") String mensaje, LocalDateTime fechaCreacion, Usuario autor, Curso curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = (fechaCreacion == null) ? LocalDateTime.now() : fechaCreacion;
        this.status = Status.ABIERTO;
        this.autor = autor;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

}
