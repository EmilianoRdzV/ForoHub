package com.geniedev.ForoHub.repositories;

import com.geniedev.ForoHub.models.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    // título
    List<Topico> findByTitulo(String titulo);

    // autor ID
    List<Topico> findByAutorId(Long autorId);

    // Verificar si existe un tópico con el mismo título y mensaje
    boolean existsByTituloAndMensaje(String titulo, String mensaje);
}
