package com.netty.im.packet;

import com.netty.im.constants.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Wu.Chunyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MessageResponsePacket extends Packet {

    private Integer fromUserId;
    private String message;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_RESPONSE;
    }
}
