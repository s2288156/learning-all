package com.all.micro.auth.controller;

import com.all.micro.auth.dto.LoginRequest;
import com.all.micro.auth.dto.ResponseData;
import com.all.micro.auth.dto.Tokens;
import com.all.micro.auth.service.IAuthService;
import jakarta.security.auth.message.AuthException;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Wu.Chunyang
 */
@RestController
public class AuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/login")
    public ResponseData<?> login(@RequestBody LoginRequest request) {
        try {
            Tokens tokens = authService.login(request.getUsername(), request.getPassword());
            return ResponseData.success(tokens);
        } catch (AuthException e) {
            return ResponseData.unauthorized();
        }
    }

    @PostMapping("/test")
    public ResponseEntity<?> debugKeycloakClient() {
        try (Keycloak client = authService.keycloakClient()) {
            RealmResource realm = client.realm("microservice");
            return ResponseEntity.ok(client.realms());
        }
    }

}
