package com.netty.demo1;

import com.netty.demo1.packet.LoginRequestPacket;
import com.netty.demo1.packet.LoginResponsePacket;
import com.netty.demo1.packet.Packet;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/**
 * @author Wu.Chunyang
 */
public class PacketCodeC {
    public static final PacketCodeC INSTANCE = new PacketCodeC();
    private static final int MAGIC_NUM = 0x12345678;

    public ByteBuf encode(ByteBufAllocator allocator,Packet packet) {
        ByteBuf byteBuf = allocator.buffer();
        byte[] bytes = Serializer.DEFAULT.serializer(packet);

        byteBuf.writeInt(MAGIC_NUM);
        byteBuf.writeByte(packet.getVersion());
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm());
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);

        return byteBuf;
    }

    public Packet decode(ByteBuf byteBuf) {
        // 跳过魔数
        byteBuf.skipBytes(4);
        // skip version
        byteBuf.skipBytes(1);
        byte serializerAlgorithm = byteBuf.readByte();
        byte command = byteBuf.readByte();
        int length = byteBuf.readInt();

        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);

        Class<? extends Packet> requestType = getRequestType(command);
        Serializer serializer = getSerializer(serializerAlgorithm);
        if (requestType != null && serializer != null) {
            return serializer.deserializer(requestType, bytes);
        }
        return null;
    }

    private Class<? extends Packet> getRequestType(byte command) {
        if (command == Command.LOGIN_REQUEST) {
            return LoginRequestPacket.class;
        } else if (command == Command.LOGIN_RESPONSE) {
            return LoginResponsePacket.class;
        }
        return null;
    }

    private Serializer getSerializer(byte serializerAlgorithm) {
        if (serializerAlgorithm == Serializer.JSON_SERIALIZER) {
            return Serializer.DEFAULT;
        }
        return null;
    }
}
