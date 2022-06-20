package com.example.edp_project;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.function.Supplier;

import com.google.gson.Gson;
public class Request{


    public LoveResponseDto CheckLove(String name1, String name2){

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://love-calculator.p.rapidapi.com/getPercentage?sname=" + name1 +"&fname=" + name2))
                .header("X-RapidAPI-Key", "f88e037d5amsh2404e23abe814b1p10d4e5jsn833517dc5790")
                .header("X-RapidAPI-Host", "love-calculator.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        CompletableFuture<HttpResponse<String>> cfResponse;
        HttpResponse<String> response;
        try {
            cfResponse = HttpClient.newHttpClient().sendAsync(request, HttpResponse.BodyHandlers.ofString());
            response = cfResponse.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new Gson().fromJson(response.body(), LoveResponseDto.class);
    }
}
