package com.all.micro.auth.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Wu.Chunyang
 */
@Data
public class AssignRolesRequest {
    private List<String> roles;
}
