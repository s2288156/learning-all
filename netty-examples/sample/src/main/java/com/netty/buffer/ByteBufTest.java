package com.netty.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Wu.Chunyang
 */
@Slf4j
public class ByteBufTest {
    public static void main(String[] args) {
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(9, 100);
        log.info("allocate ByteBuf(9,100) \t\t {}", buffer);

        buffer.writeBytes(new byte[]{1, 2, 3, 4});
        log.info("writeBytes(1, 2, 3, 4) \t\t\t {}", buffer);

        buffer.writeInt(12);
        log.info("writeInt(12) \t\t\t\t\t {}", buffer);

        buffer.writeBytes(new byte[]{5});
        log.info("writeBytes(5) \t\t\t\t\t {}", buffer);

        buffer.writeBytes(new byte[]{6});
        log.info("writeBytes(6) 发生扩容 \t\t\t {}", buffer);

        log.info("getByte(3) return: {}", buffer.getByte(3));
        log.info("getShort(3) return: {}", buffer.getShort(3));
        log.info("getInt(3) return: {}", buffer.getInt(3));
        log.info("getByte() {}", buffer);

        log.info("buffer.setByte(buffer.readableBytes() + 1, 0) \t buffer.readableBytes() = {}", buffer.readableBytes());
        buffer.setByte(buffer.readableBytes() + 1, 0);
        log.info("setByte() {}", buffer);

    }
}
