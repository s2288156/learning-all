package com.netty.demo1.packet;

import com.netty.demo1.Command;
import lombok.Data;

/**
 * @author Wu.Chunyang
 */
@Data
public class MessageRequestPacket extends Packet {

    private String message;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_REQUEST;
    }
}
