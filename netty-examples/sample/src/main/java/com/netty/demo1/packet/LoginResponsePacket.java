package com.netty.demo1.packet;

import com.netty.demo1.constants.Command;
import lombok.Data;

/**
 * @author Wu.Chunyang
 */
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
