package com.netty.demo1.packet;

import com.netty.demo1.Command;
import lombok.Data;

/**
 * @author Wu.Chunyang
 */
@Data
public class LoginResponsePacket extends Packet {

    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
