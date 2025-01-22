package com.geniedev.ForoHub.repositories;

import com.geniedev.ForoHub.models.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    // Buscar perfil por nombre (ADMIN, ESTUDIANTE, etc.)
    Perfil findByNombre(String nombre);
}
