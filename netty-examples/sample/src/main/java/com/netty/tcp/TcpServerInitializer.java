package com.netty.tcp;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Arrays;

/**
 * @author Wu.Chunyang
 */
public class TcpServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline()
                .addLast(new DelimiterBasedFrameDecoder(Integer.MAX_VALUE, false, Unpooled.wrappedBuffer("STX".getBytes())))
                .addLast(new DelimiterBasedFrameDecoder(Integer.MAX_VALUE, false, Unpooled.wrappedBuffer("ETX".getBytes())))
                // .addLast(new StringDecoder())
                // .addLast(new TcpServerHandler())
                .addLast(new TcpByteServerHandler())
                .addLast(new StringEncoder());
        // .addLast(new DnsTcpServerHandler());
    }

    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static void main(String[] args) {
        byte[] bytes = "0".getBytes();
        System.out.println(bytesToHex(bytes));  // 输出：0A0B0C0D
    }
}
