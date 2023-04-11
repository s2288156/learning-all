package com.netty.sample.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author Wu.Chunyang
 */
@Slf4j
public class EchoClient {
    public static void main(String[] args) {
        EchoClient client = new EchoClient("127.0.0.1", 8889);
        client.init();
    }

    private String host;
    private int port;
    private final NioEventLoopGroup worker;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
        worker = new NioEventLoopGroup();
    }

    public void init() {

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(worker)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline()
                                .addLast(new StringDecoder())
                                .addLast(new EchoClientHandler());
                    }
                });
        connect(bootstrap, MAX_RETRY);
    }

    private final int MAX_RETRY = 3;

    private void connect(Bootstrap bootstrap, int retry) {
        bootstrap.connect(host, port).addListener(future -> {
            if (future.isSuccess()) {
                log.info("connect {}:{} success", host, port);
            } else if (retry == 0) {
                log.error("connect {}:{} failed", host, port);
                worker.shutdownGracefully();
            } else {
                int order = (MAX_RETRY - retry) + 1;
                int delay = 1 << order;
                log.warn("retry connect {}:{} for {} times", host, port, order);
                bootstrap.config().group().schedule(() -> connect(bootstrap, retry - 1), delay, TimeUnit.SECONDS);
            }
        });
    }
}
