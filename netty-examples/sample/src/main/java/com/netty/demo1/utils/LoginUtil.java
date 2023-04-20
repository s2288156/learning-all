package com.netty.demo1.utils;

import com.netty.demo1.constants.Attributes;
import io.netty.channel.Channel;

/**
 * @author Wu.Chunyang
 */
public class LoginUtil {
    public static void markAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(true);
    }

    public static boolean hasLogin(Channel channel) {
        Boolean loginAttr = channel.attr(Attributes.LOGIN).get();
        return loginAttr != null && loginAttr;
    }
}
