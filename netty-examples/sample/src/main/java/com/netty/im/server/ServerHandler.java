package com.netty.im.server;

import com.netty.im.PacketCodeC;
import com.netty.im.packet.*;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Wu.Chunyang
 */
@Deprecated
@Slf4j
public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        Packet packet = PacketCodeC.INSTANCE.decode(byteBuf);
        if (packet instanceof LoginRequestPacket loginRequestPacket) {
            LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
            loginResponsePacket.setVersion(packet.getVersion());
            if (valid(loginRequestPacket)) {
                log.info("登录验证通过: {}", loginRequestPacket);
                loginResponsePacket.setSuccess(true);
                loginResponsePacket.setReason("登录成功.");
            } else {
                log.warn("登录验证失败.");
                loginResponsePacket.setSuccess(false);
                loginResponsePacket.setReason("登录失败.");
            }
            ByteBuf response = PacketCodeC.INSTANCE.encode(ctx.alloc(), loginResponsePacket);
            ctx.channel().writeAndFlush(response);
        } else if (packet instanceof MessageRequestPacket messageRequestPacket) {
            log.info("收到客户端消息: {}", messageRequestPacket.getMessage());

            MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
            messageResponsePacket.setMessage("服务端回复【" + messageRequestPacket.getMessage() + "】");

            ctx.channel().writeAndFlush(PacketCodeC.INSTANCE.encode(ctx.alloc(), messageResponsePacket));
        }
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }
}
