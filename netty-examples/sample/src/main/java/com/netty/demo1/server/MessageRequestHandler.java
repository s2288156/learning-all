package com.netty.demo1.server;

import com.netty.demo1.packet.MessageRequestPacket;
import com.netty.demo1.packet.MessageResponsePacket;
import com.netty.demo1.packet.Session;
import com.netty.demo1.utils.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Wu.Chunyang
 */
@Slf4j
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket msg) throws Exception {
        Session session = SessionUtil.getSession(ctx.channel());
        log.info("收到客户端{}消息: {}", session.getUserId(), msg.getMessage());
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setFromUserId(session.getUserId());
        messageResponsePacket.setMessage("服务端回复【" + msg.getMessage() + "】");
        // ctx.channel().writeAndFlush(messageResponsePacket);
        SessionUtil.getChannel(msg.getToUserId()).writeAndFlush(messageResponsePacket);
    }
}
