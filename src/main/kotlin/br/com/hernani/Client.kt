package br.com.hernani

import io.grpc.ManagedChannelBuilder

fun main() {

    val request = FuncionarioRequest.newBuilder()
        .setNome("hernani")
        .setCpf("111-111-111-11")
        .setIdade(33)
        .setCargo(Cargo.DEV)
        .addEnderecos(
            Endereco.newBuilder()
                .setLogradouro("rua 1")
                .setCep("11111111")
        )
        .build()

    val channel = ManagedChannelBuilder
        .forAddress("localhost", 50051)
        .usePlaintext()
        .build()

    val client = FuncionarioServiceGrpc.newBlockingStub(channel)
    val response = client.cadastraFuncionario(request)

    println(response)
}