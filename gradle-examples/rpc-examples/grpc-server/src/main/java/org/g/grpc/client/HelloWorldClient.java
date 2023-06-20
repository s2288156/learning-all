package org.g.grpc.client;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.g.grpc.api.GreeterApiGrpc;
import org.g.grpc.api.HelloReply;
import org.g.grpc.api.HelloRequest;

/**
 * @author Wu.Chunyang
 */
public class HelloWorldClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:50051")
                .usePlaintext()
                .build();
        HelloWorldClient client = new HelloWorldClient(channel);
        client.greet("Zhang San");
    }

    private final GreeterApiGrpc.GreeterApiBlockingStub blockingStub;

    public HelloWorldClient(Channel channel) {
        blockingStub = GreeterApiGrpc.newBlockingStub(channel);
    }

    public void greet(String name) {
        System.out.println("Will try to greet " + name + " ...");
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloReply response;
        response = blockingStub.sayHello(request);
        System.out.println(response.getMessage());
    }
}
