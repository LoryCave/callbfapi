package com.deepcave.calls;

import com.deepcave.models.Content;
import com.deepcave.models.Embed;
import com.deepcave.models.Notizia;
import com.deepcave.models.discord.Message;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class News {

    public String createNews(String titolo, String contenuto, String image) {
        try {
            Gson gson = new Gson();

            String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

            Message dsmesage = sendEmbed(titolo, contenuto, 4429263);
            Notizia data = new Notizia(
                titolo,
                contenuto,
                timeStamp,
                image,
                dsmesage.getId()
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private Message sendEmbed(String titolo, String descrizione, Integer colore) {
        try {
            Gson gson = new Gson();

            List<Embed> embeds = new ArrayList<>();
            embeds.add(new Embed(titolo, descrizione, colore));

            Content data = new Content(
                "||<@&1204492635990134794>||",
                embeds
            );

            String jsonRequest = gson.toJson(data);

            HttpRequest postRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://bfapi.apimanager.space:8443/bfapi/api/discord/message/1053815122063274005"))
                    .header("Content-type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<?> httpResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());

            return gson.fromJson(httpResponse.body().toString(), Message.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
