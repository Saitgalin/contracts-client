package com.test.contractsclient;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RemoteController implements ContractsController {

    private final HttpClient client = HttpClient.newHttpClient();

    @Override
    public Contract[] getContracts() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/contracts"))
                .GET()
                .build();

        String contractsString = client.send(request, HttpResponse.BodyHandlers.ofString()).body();

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(contractsString, Contract[].class);
    }
}
