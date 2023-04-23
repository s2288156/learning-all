package com.netty.im.server;

import com.netty.im.packet.MessageRequestPacket;
import com.netty.im.packet.MessageResponsePacket;
import com.netty.im.packet.Session;
import com.netty.im.utils.SessionUtil;
import io.netty.channel.Channel;
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
        // 通过toUserId获取消息接收方channel，将消息发送出去
        Channel toChannel = SessionUtil.getChannel(msg.getToUserId());
        if (toChannel != null) {
            toChannel.writeAndFlush(messageResponsePacket);
        } else {
            log.error("userId: {}, 未登录.", msg.getToUserId());
        }
    }
}
