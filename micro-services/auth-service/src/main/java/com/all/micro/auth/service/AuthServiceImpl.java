package com.all.micro.auth.service;

import com.all.micro.auth.dto.Tokens;
import jakarta.security.auth.message.AuthException;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

/**
 * @author Wu.Chunyang
 */
@Service
public class AuthServiceImpl implements IAuthService {
    @Value("${keycloak.auth-server-url}")
    private String authServerUrl;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.client.id}")
    private String clientId;

    @Value("${keycloak.client.secret}")
    private String clientSecret;

    private final WebClient webClient = WebClient.builder().build();

    @Override
    public Tokens login(String username, String password) throws AuthException {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", clientId);
        formData.add("client_secret", clientSecret);
        formData.add("username", username);
        formData.add("password", password);
        formData.add("grant_type", "password");

        Map<String, Object> response = webClient.post()
                .uri(authServerUrl + "/realms/" + realm + "/protocol/openid-connect/token")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(formData))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                .block();
        return new Tokens(
                (String) response.get("access_token"),
                (String) response.get("refresh_token"),
                ((Number) response.get("expires_in")).longValue()
        );
    }

    // 2. 获取 Keycloak 管理客户端（用于用户/角色操作）
    // ========================
    @Override
    public Keycloak keycloakClient() {
        return KeycloakBuilder.builder()
                .serverUrl(authServerUrl)
                .realm(realm)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .build();
    }
}
