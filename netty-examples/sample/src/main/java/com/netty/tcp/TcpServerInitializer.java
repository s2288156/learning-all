package com.netty.tcp;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author Wu.Chunyang
 */
public class TcpServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline()
                .addLast(new StringDecoder())
                .addLast(new TcpServerHandler())
                .addLast(new StringEncoder());
        // .addLast(new DnsTcpServerHandler());
    }
}
