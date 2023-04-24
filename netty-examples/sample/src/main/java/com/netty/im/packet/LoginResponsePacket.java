package com.netty.im.packet;

import com.netty.im.constants.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Wu.Chunyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LoginResponsePacket extends Packet {
    private Integer userId;

    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }
}
