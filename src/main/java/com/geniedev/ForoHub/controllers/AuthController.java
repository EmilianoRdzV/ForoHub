package com.geniedev.ForoHub.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        // Aquí iría la lógica de autenticación con Spring Security (JWT)
        if (email.equals("admin@foro.com") && password.equals("1234")) {
            return ResponseEntity.ok("TokenJWT");
        }
        return ResponseEntity.status(401).body("Credenciales inválidas");
    }
}
