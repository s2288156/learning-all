package com.netty.demo1.constants;

import com.netty.demo1.packet.Session;
import io.netty.util.AttributeKey;

/**
 * @author Wu.Chunyang
 */
public class Attributes {
    public static final AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
    public static final AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
    public static final AttributeKey<Integer> USER_ID = AttributeKey.newInstance("userId");
}
