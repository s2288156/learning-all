package com.netty.im.client;

import com.netty.im.packet.LoginResponsePacket;
import com.netty.im.utils.LoginUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Wu.Chunyang
 */
@Slf4j
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket msg) {
        if (msg.isSuccess()) {
            log.info("{}", msg.getReason());
            LoginUtil.markAsLogin(ctx.channel(), msg.getUserId());
        } else {
            log.warn("登录失败.");
        }
    }

}
