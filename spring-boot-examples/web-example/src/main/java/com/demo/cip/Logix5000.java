package com.demo.cip;

import com.digitalpetri.enip.EtherNetIpClient;
import com.digitalpetri.enip.EtherNetIpClientConfig;
import com.digitalpetri.enip.EtherNetIpShared;
import com.digitalpetri.enip.cip.epath.DataSegment;
import com.digitalpetri.enip.cip.epath.EPath;
import com.digitalpetri.enip.cip.epath.LogicalSegment;
import com.digitalpetri.enip.cip.services.GetAttributeListService;
import com.digitalpetri.enip.commands.ListServices;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.concurrent.ExecutionException;

@Slf4j
public class Logix5000 {
    @SneakyThrows
    public static void main(String[] args) {
        EtherNetIpClientConfig config = EtherNetIpClientConfig.builder("127.0.0.1")
                .setSerialNumber(0x03)
                .setVendorId(0x00)
                .setTimeout(Duration.ofSeconds(2))
                .build();

        enip(config);
    }


    private static void enip(EtherNetIpClientConfig config) throws InterruptedException, ExecutionException {
        EtherNetIpClient client = new EtherNetIpClient(config);

        client.connect().get();

        client.listIdentity().whenComplete((li, ex) -> {
            if (li != null) {
                li.getIdentityItem().ifPresent(id -> {
                    log.info("""
                                    productName: {}
                                    revisionMajor: {}
                                    revisionMinor: {}
                                    deviceType: {}
                                    productCode: {}
                                    serialNumber: {}
                                    socketAddress_port: {}
                                    state: {}
                                    status: {}
                                    """,
                            id.getProductName(),
                            id.getRevisionMajor(),
                            id.getRevisionMinor(),
                            id.getDeviceType(),
                            id.getProductCode(),
                            id.getSerialNumber(),
                            id.getSocketAddress().getSinPort(),
                            id.getState(),
                            id.getStatus()
                    );
                });
            } else {
                log.error("", ex);
            }
        });

        client.disconnect().get();

        // Call this before application / JVM shutdown
        EtherNetIpShared.releaseSharedResources();
    }
}
