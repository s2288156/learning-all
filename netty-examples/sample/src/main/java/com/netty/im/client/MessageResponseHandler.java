package com.netty.im.client;

import com.netty.im.packet.MessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;

/**
 * @author Wu.Chunyang
 */
@Slf4j
public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageResponsePacket msg) {
        System.out.println(MessageFormat.format("收到服务端[{0}]消息: {1}", msg.getFromUserId(), msg.getMessage()));
    }
}
