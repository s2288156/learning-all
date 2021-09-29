package com.example.es.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wuyang
 */
@Data
public class Address implements Serializable {
    private static final long serialVersionUID = -3318956769480936703L;

    private String location;

    private String zipCode;
}
