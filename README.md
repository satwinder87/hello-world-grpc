# hello-world-grpc
gRPC Hello World


brew install grpcurl

# grpCurl commands

grpcurl -plaintext localhost:9090 list

echo '{"firstName":"ENG","lastName":"2.2"}' |  grpcurl -plaintext -d @ localhost:9090 com.learning.grpc.HelloService.hello
