package com.learning;

import com.learning.grpc.HelloServiceGrpc;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(com.learning.grpc.HelloRequest request,
                      io.grpc.stub.StreamObserver<com.learning.grpc.HelloResponse> responseObserver){

        System.out.println("Request Received: " + request);

        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .toString();

        com.learning.grpc.HelloResponse response = com.learning.grpc.HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }



}
