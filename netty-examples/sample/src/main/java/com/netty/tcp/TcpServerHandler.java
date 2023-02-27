package com.netty.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;

/**
 * @author Wu.Chunyang
 */
@Slf4j
public class TcpServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        log.info("@ {}", ByteBufUtil.getBytes(buf));
        log.info("@@@ {}", buf.toString(StandardCharsets.UTF_8));
        super.channelRead(ctx, msg);
    }

    public static void main(String[] args) {
        System.out.println(0xab);
        System.out.println(Integer.toHexString(14));
    }
}
