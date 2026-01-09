package com.all.micro.auth.dto;

import lombok.Data;

/**
 * @author Wu.Chunyang
 */
@Data
public class UpdateUserRequest {
    private String email;
    private String firstName;
    private String lastName;
}
