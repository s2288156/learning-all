package com.netty.demo1.packet;

import com.netty.demo1.Command;
import lombok.Data;

/**
 * @author Wu.Chunyang
 */
@Data
public class LoginRequestPacket extends Packet {

    private Integer userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
