package com.all.micro.auth.dto;

import lombok.Data;

/**
 * @author Wu.Chunyang
 */
@Data
public class LoginRequest {
    private String username;
    private String password;
}
