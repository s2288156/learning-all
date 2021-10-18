package com.netty.sample.simplehandler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * 入参解码
 */
public class NetWorkDecoder extends ByteToMessageDecoder {
    public final int BASE_LENGTH = 3;
    public final int MAX_LENGTH = 1024;

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        // 可读长度必须大于基本长度, 且防止socket字节流攻击 防止，客户端传来的数据过大
        if (in.readableBytes() < BASE_LENGTH || in.readableBytes() > MAX_LENGTH) {
            in.skipBytes(in.readableBytes());
            return;
        }

        String originalData = ByteBufUtil.hexDump(in);


        // 读取原始数据串 不会改变ByteBuf 索引
        try {
            out.add(originalData);
        } catch (Exception e) {
        }
        in.skipBytes(in.readableBytes());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}