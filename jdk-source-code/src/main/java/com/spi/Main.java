package com.spi;

/**
 * @author Wu.Chunyang
 */
public class Main {
    public static void main(String[] args) {
        LoggerService service = LoggerService.getService();
        service.info("Hello");
        service.debug("Hello");
    }
}
