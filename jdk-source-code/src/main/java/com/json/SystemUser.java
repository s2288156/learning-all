package com.json;

import lombok.Data;

/**
 * @author Wu.Chunyang
 */
@Data
public class SystemUser implements User {

    private String username;

    private Integer age;

    public SystemUser() {
    }
}
