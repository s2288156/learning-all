package com.leetcode.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Wu.Chunyang
 */
public class JacksonUtils {

    private static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
    }

    public static ObjectMapper getObjectMapper() {
        return OBJECT_MAPPER;
    }
}
