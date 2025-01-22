package com.geniedev.ForoHub.repositories;

import com.geniedev.ForoHub.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    // cursos por nombre
    List<Curso> findByNombreContaining(String nombre);

    // Verificar si un curso existe
    boolean existsByNombre(String nombre);
}
