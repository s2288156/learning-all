package com.netty.im.packet;

import lombok.Data;

/**
 * @author Wu.Chunyang
 */
@Data
public abstract class Packet {

    private Byte version = 1;

    public abstract Byte getCommand();

}
