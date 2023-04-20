package com.netty.demo1.client;

import com.netty.demo1.PacketCodeC;
import com.netty.demo1.packet.MessageRequestPacket;
import com.netty.demo1.utils.LoginUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Wu.Chunyang
 */
@Slf4j
public class DemoClient {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ClientHandler());
                    }
                });
        bootstrap.connect("127.0.0.1", 8888)
                .sync().addListener(future -> {
                    if (future.isSuccess()) {
                        Channel channel = ((ChannelFuture) future).channel();
                        startConsoleTread(channel);
                    }
                });
    }

    private static void startConsoleTread(Channel channel) {
        new Thread(() -> {
            while (!Thread.interrupted() && LoginUtil.hasLogin(channel)) {
                log.info("输入消息发送至服务端: ");
                Scanner scanner = new Scanner(System.in);
                String line = scanner.nextLine();
                MessageRequestPacket messageRequestPacket = new MessageRequestPacket();
                messageRequestPacket.setMessage(line);
                channel.writeAndFlush(PacketCodeC.INSTANCE.encode(channel.alloc(), messageRequestPacket));
            }
        }).start();
    }
}
