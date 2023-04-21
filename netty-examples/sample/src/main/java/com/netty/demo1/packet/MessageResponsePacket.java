package com.netty.demo1.packet;

import com.netty.demo1.constants.Command;
import lombok.Data;

/**
 * @author Wu.Chunyang
 */
@Data
public class MessageResponsePacket extends Packet {

    private Integer fromUserId;
    private String message;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_RESPONSE;
    }
}
