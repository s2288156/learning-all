package com.netty.im.server;

import com.netty.im.packet.LoginRequestPacket;
import com.netty.im.packet.LoginResponsePacket;
import com.netty.im.packet.Session;
import com.netty.im.utils.LoginUtil;
import com.netty.im.utils.SessionUtil;
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
            Session session = SessionUtil.newSession(msg.getUsername());
            SessionUtil.bindSession(session, ctx.channel());
            LoginUtil.markAsLogin(ctx.channel());
            loginResponsePacket.setUserId(session.getUserId());
            loginResponsePacket.setSuccess(true);
            loginResponsePacket.setReason(session.getUserId() + ": " + session.getUsername() + " 登录成功.");
        } else {
            log.warn("登录验证失败.");
            loginResponsePacket.setSuccess(false);
            loginResponsePacket.setReason("登录失败.");
        }
        ctx.channel().writeAndFlush(loginResponsePacket);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        if (LoginUtil.hasLogin(ctx.channel())) {
            Session session = SessionUtil.getSession(ctx.channel());
            SessionUtil.removeChannel(session);
            log.info("{} 移除", session);
        }
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }
}
