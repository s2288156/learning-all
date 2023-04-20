package com.netty.demo1.client;

import com.netty.demo1.packet.LoginRequestPacket;
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
            LoginUtil.markAsLogin(ctx.channel());
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("开始登录...");
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserId(1);
        loginRequestPacket.setUsername("laowang");
        loginRequestPacket.setPassword("112233");
        ctx.channel().writeAndFlush(loginRequestPacket);
    }
}
