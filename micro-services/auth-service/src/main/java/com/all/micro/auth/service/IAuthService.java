package com.all.micro.auth.service;

import com.all.micro.auth.dto.Tokens;
import jakarta.security.auth.message.AuthException;
import org.keycloak.admin.client.Keycloak;

/**
 * @author Wu.Chunyang
 */
public interface IAuthService {

    Tokens login(String username, String password) throws AuthException;

    Keycloak keycloakClient();
}
