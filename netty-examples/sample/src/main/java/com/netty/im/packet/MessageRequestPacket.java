package com.netty.im.packet;

import com.netty.im.constants.Command;
import lombok.Data;

/**
 * @author Wu.Chunyang
 */
@Data
public class MessageRequestPacket extends Packet {

    private Integer toUserId;
    private String message;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_REQUEST;
    }
}
