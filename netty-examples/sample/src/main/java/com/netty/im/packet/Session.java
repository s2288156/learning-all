package com.netty.im.packet;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Wu.Chunyang
 */
@AllArgsConstructor
@Data
public class Session {

    private Integer userId;
    private String username;
}
