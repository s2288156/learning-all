package com.netty.demo1;

import com.netty.demo1.constants.SerializerAlgorithm;
import com.netty.utils.JacksonUtil;

/**
 * @author Wu.Chunyang
 */
public class JsonSerializer implements Serializer{
    @Override
    public byte getSerializerAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serializer(Object object) {
        return JacksonUtil.toBytes(object);
    }

    @Override
    public <T> T deserializer(Class<T> clazz, byte[] bytes) {
        return JacksonUtil.readValue(bytes, clazz);
    }
}
