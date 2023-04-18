package com.netty.demo1.client;

import com.netty.demo1.PacketCodeC;
import com.netty.demo1.packet.LoginRequestPacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Wu.Chunyang
 */
@Slf4j
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("开始登录...");
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserId(1);
        loginRequestPacket.setUsername("laowang");
        loginRequestPacket.setPassword("112233");

        ByteBuf request = PacketCodeC.INSTANCE.encode(ctx.alloc(), loginRequestPacket);

        ctx.channel().writeAndFlush(request);
    }
}
