package com.netty.im.packet;

import com.netty.im.constants.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Wu.Chunyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MessageRequestPacket extends Packet {

    private Integer toUserId;
    private String message;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_REQUEST;
    }
}
