package com.netty.demo1.server;

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
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket msg) throws Exception {
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(msg.getVersion());
        if (valid(msg)) {
            log.info("登录验证通过: {}", msg);
            LoginUtil.markAsLogin(ctx.channel());
            loginResponsePacket.setSuccess(true);
            loginResponsePacket.setReason("登录成功.");
        } else {
            log.warn("登录验证失败.");
            loginResponsePacket.setSuccess(false);
            loginResponsePacket.setReason("登录失败.");
        }
        ctx.channel().writeAndFlush(loginResponsePacket);
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }
}
