package com.learning.client;

import com.learning.grpc.HelloRequest;
import com.learning.grpc.HelloResponse;
import com.learning.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("satwinder")
                .setLastName("singh")
                .build());

        System.out.println(helloResponse.getGreeting());

        channel.shutdown();
    }
}
