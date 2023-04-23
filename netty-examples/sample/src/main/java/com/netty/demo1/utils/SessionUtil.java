package com.netty.demo1.utils;

import com.netty.demo1.constants.Attributes;
import com.netty.demo1.packet.Session;
import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Wu.Chunyang
 */
public class SessionUtil {
    private static Integer userIdIndex = 0;

    private static final Map<Integer, Channel> userIdChannelStore = new ConcurrentHashMap<>();

    public static Session newSession(String username) {
        return new Session(userIdIndex++, username);
    }

    public static void bindSession(Session session, Channel channel) {
        channel.attr(Attributes.SESSION).set(session);
        userIdChannelStore.put(session.getUserId(), channel);
    }

    public static Session getSession(Channel channel) {
        return channel.attr(Attributes.SESSION).get();
    }

    public static Channel getChannel(Integer toUserId) {
        return userIdChannelStore.get(toUserId);
    }

    public static void removeChannel(Session session) {
        if (session != null) {
            userIdChannelStore.remove(session.getUserId());
        }
    }
}
