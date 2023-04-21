package com.netty.demo1.server;

import com.netty.demo1.utils.LoginUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Wu.Chunyang
 */
@Slf4j
public class AuthHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (LoginUtil.hasLogin(ctx.channel())) {
            log.info("认证成功.");
            ctx.pipeline().remove(this);
            super.channelRead(ctx, msg);
        } else {
            log.info("认证失败, 关闭连接.");
            ctx.channel().close();
        }
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        if (LoginUtil.hasLogin(ctx.channel())) {
            log.info("认证成功 auth handler 移除");
        } else {
            log.info("未登录验证，关闭连接");
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        log.info("channelInactive");
    }
}
