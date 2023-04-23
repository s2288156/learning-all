package com.netty.im.packet;

import com.netty.im.constants.Command;
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
