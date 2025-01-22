package com.geniedev.ForoHub.repositories;

import com.geniedev.ForoHub.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // usuario por correo electrónico
    Optional<Usuario> findByCorreoElectronico(String correoElectronico);

    // Verificar si existe un usuario con el mismo correo electrónico
    boolean existsByCorreoElectronico(String correoElectronico);
}
