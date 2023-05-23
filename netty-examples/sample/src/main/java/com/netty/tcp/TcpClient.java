package com.netty.tcp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Wu.Chunyang
 */
@Slf4j
public class TcpClient {
    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline()
                                .addLast(new StringDecoder())
                                .addLast(new TcpClientHandler())
                                .addLast(new StringEncoder());
                    }
                });
        Channel channel = null;
        try {
            channel = bootstrap.connect("127.0.0.1", 9999).sync().channel();
            // channel.writeAndFlush("send - ");
            for (int j = 0; j < 1000; j++) {
                channel.writeAndFlush("STX send - " + j + " ETX");
                log.info("j = {}", j);
            }
        } catch (InterruptedException e) {
            log.error("", e);
        }
    }
}
