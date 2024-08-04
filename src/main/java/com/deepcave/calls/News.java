package com.deepcave.calls;

import com.deepcave.models.Notizia;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;

public class News {

    public String createNews(String titolo, String contenuto, String image) throws URISyntaxException, IOException, InterruptedException {
        Gson gson = new Gson();

        Notizia data = new Notizia(
            titolo,
            contenuto,
            new Date(),
            image,
            null
        );

        String jsonRequest = gson.toJson(data);

        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8181/api/news/new"))
                .header("Content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<?> httpResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());

        return httpResponse.body().toString();
    }

}
