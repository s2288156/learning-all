package com.all.micro.auth.dto;

import lombok.Data;

/**
 * @author Wu.Chunyang
 */
@Data
public class UserInfo {
    private String id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
}
