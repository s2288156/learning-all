package com.netty.demo1.client;

import com.netty.demo1.packet.LoginResponsePacket;
import com.netty.demo1.utils.LoginUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Wu.Chunyang
 */
@Slf4j
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket msg) throws Exception {
        if (msg.isSuccess()) {
            log.info("{}", msg.getReason());
            LoginUtil.markAsLogin(ctx.channel(), msg.getUserId());
        } else {
            log.warn("登录失败.");
        }
    }

}
