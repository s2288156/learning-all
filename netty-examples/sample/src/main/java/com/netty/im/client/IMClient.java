package com.netty.im.client;

import com.netty.im.coder.PacketDecoder;
import com.netty.im.coder.PacketEncoder;
import com.netty.im.packet.LoginRequestPacket;
import com.netty.im.packet.MessageRequestPacket;
import com.netty.im.utils.LoginUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author Wu.Chunyang
 */
@Slf4j
public class IMClient {
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
                } else {
                    System.out.println("输入消息发送至服务端，命令格式: [userId] [message]");
                    Scanner scanner = new Scanner(System.in);
                    String cmd = scanner.nextLine();
                    String[] commands = StringUtils.split(cmd, " ");
                    if (commands == null || commands.length != 2) {
                        System.out.println("命令格式错误，请重新输入.");
                    } else {
                        String userId = commands[0];
                        String message = commands[1];
                        MessageRequestPacket messageRequestPacket = new MessageRequestPacket();
                        messageRequestPacket.setToUserId(Integer.valueOf(userId));
                        messageRequestPacket.setMessage(message);
                        channel.writeAndFlush(messageRequestPacket);
                    }
                }
                waitResponse();
            }
        }).start();
    }

    private static void waitResponse() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
