package com.all.micro.auth.dto;

import lombok.Data;

/**
 * @author Wu.Chunyang
 */
@Data
public class Tokens {
    private String accessToken;

    private String refreshToken;

    /**
     * seconds
     */
    private long expiresIn;

    public Tokens(String accessToken, String refreshToken, long expiresIn) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expiresIn = expiresIn;
    }
}
