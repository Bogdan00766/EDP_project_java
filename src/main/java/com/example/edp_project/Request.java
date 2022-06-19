package com.example.edp_project;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
public class Request extends Thread{


    public int CheckLove(String name1, String name2){

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://love-calculator.p.rapidapi.com/getPercentage?sname=" + name1 +"&fname=" + name2))
                .header("X-RapidAPI-Key", "f88e037d5amsh2404e23abe814b1p10d4e5jsn833517dc5790")
                .header("X-RapidAPI-Host", "love-calculator.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        LoveResponseDto lr = new Gson().fromJson(response.body(), LoveResponseDto.class);
        return lr.percentage;
    }
}
