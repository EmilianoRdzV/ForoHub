package com.geniedev.ForoHub.repositories;

import com.geniedev.ForoHub.models.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

    // Obtener respuestas
    List<Respuesta> findByTopicoId(Long topicoId);

    // Respuesta usuario específico
    List<Respuesta> findByAutorId(Long autorId);
}
