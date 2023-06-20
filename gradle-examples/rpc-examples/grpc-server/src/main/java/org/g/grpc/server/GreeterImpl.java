package org.g.grpc.server;

import io.grpc.stub.StreamObserver;
import org.g.grpc.api.GreeterGrpc;
import org.g.grpc.api.HelloReply;
import org.g.grpc.api.HelloRequest;

/**
 * @author Wu.Chunyang
 */
public class GreeterImpl extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
