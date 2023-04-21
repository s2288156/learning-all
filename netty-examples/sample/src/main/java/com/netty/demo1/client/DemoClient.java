package com.netty.demo1.client;

import com.netty.demo1.PacketCodeC;
import com.netty.demo1.coder.PacketDecoder;
import com.netty.demo1.coder.PacketEncoder;
import com.netty.demo1.packet.LoginRequestPacket;
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
import java.util.concurrent.TimeUnit;

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
                        ch.pipeline()
                                .addLast(new PacketDecoder())
                                .addLast(new LoginResponseHandler())
                                .addLast(new MessageResponseHandler())
                                .addLast(new PacketEncoder());
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
            while (!Thread.interrupted()) {
                if (!LoginUtil.hasLogin(channel)) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("请输入用户名登录: ");
                    String username = scanner.nextLine();
                    LoginRequestPacket login = new LoginRequestPacket();
                    login.setUsername(username);
                    login.setPassword("pwd");
                    channel.writeAndFlush(login);
                    waitResponse();
                } else {
                    log.info("输入消息发送至服务端: ");
                    Scanner scanner = new Scanner(System.in);
                    String line = scanner.nextLine();
                    MessageRequestPacket messageRequestPacket = new MessageRequestPacket();
                    messageRequestPacket.setMessage(line);
                    channel.writeAndFlush(PacketCodeC.INSTANCE.encode(channel.alloc(), messageRequestPacket));
                }
            }
        }).start();
    }

    private static void waitResponse() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
