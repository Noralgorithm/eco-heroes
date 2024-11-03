protoc --plugin=protoc-gen-java-grpc=./protoc-gen-grpc-java-1.68.1-windows-x86_64.exe --java-grpc_out=../client/core/src/main/java --java_out=../client/core/src/main/java *.proto && echo Succesfully compiled!

read