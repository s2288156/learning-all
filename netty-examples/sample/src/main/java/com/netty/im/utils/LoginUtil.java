package com.netty.im.utils;

import com.netty.im.constants.Attributes;
import io.netty.channel.Channel;

/**
 * @author Wu.Chunyang
 */
public class LoginUtil {
    public static void markAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(true);
    }

    public static void markAsLogin(Channel channel, Integer userId) {
        channel.attr(Attributes.LOGIN).set(true);
        channel.attr(Attributes.USER_ID).set(userId);
    }

    public static boolean hasLogin(Channel channel) {
        Boolean loginAttr = channel.attr(Attributes.LOGIN).get();
        return loginAttr != null && loginAttr;
    }
}
