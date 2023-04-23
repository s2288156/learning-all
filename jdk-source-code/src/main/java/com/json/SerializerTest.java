package com.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Wu.Chunyang
 */
public class SerializerTest {
    private static final ObjectMapper JSON = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        User sysUser = new SystemUser();
        sysUser.setUsername("aaaa");
        sysUser.setAge(3);

        System.out.println(JSON.writeValueAsString(sysUser));
        String json = "{\"username\":\"aaaa\",\"age\":3}";
        User user = JSON.readValue(json, SystemUser.class);
        System.out.println(user);
    }
}
