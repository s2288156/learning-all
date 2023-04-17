package com.netty.demo1;

import lombok.Data;

/**
 * @author Wu.Chunyang
 */
@Data
public abstract class Packet {

    private Byte version = 1;

    public abstract Byte getCommand();

}
