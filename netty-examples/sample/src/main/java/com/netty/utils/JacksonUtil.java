package com.netty.utils;


import tools.jackson.databind.ObjectMapper;

/**
 * @author Wu.Chunyang
 */
public class JacksonUtil {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
//        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static <T> T readValue(byte[] bytes, Class<T> clazz) {
        return OBJECT_MAPPER.readValue(bytes, clazz);

    }

    public static byte[] toBytes(Object object) {
        return OBJECT_MAPPER.writeValueAsBytes(object);

    }

}
