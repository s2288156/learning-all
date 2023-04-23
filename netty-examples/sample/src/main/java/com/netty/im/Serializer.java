package com.netty.im;

/**
 * @author Wu.Chunyang
 */
public interface Serializer {
    byte JSON_SERIALIZER = 1;

    Serializer DEFAULT = new JsonSerializer();

    byte getSerializerAlgorithm();

    byte[] serializer(Object object);

    <T> T deserializer(Class<T> clazz, byte[] bytes);

}
