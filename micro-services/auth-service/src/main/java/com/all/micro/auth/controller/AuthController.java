package com.all.micro.auth.controller;

import com.all.micro.auth.dto.LoginRequest;
import com.all.micro.auth.dto.Tokens;
import com.all.micro.auth.service.IAuthService;
import jakarta.security.auth.message.AuthException;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.RealmRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Wu.Chunyang
 */
@RestController
public class AuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            Tokens tokens = authService.login(request.getUsername(), request.getPassword());
            return ResponseEntity.ok(tokens);
        } catch (AuthException e) {
            return ResponseEntity.status(401).body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/test")
    public ResponseEntity<?> debugKeycloakClient() {
        try (Keycloak client = authService.keycloakClient()) {
            List<RealmRepresentation> realms = client.realms().findAll();
            return ResponseEntity.ok(realms);
        }
    }
}
