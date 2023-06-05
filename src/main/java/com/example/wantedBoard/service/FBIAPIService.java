package com.example.wantedBoard.service;

import com.example.wantedBoard.model.Criminal;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class FBIAPIService {
    private static final String FBI_API_URL = "https://api.fbi.gov/wanted/v1/list?field_offices=chicago";

    private final WebClient webClient;

    public FBIAPIService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public List<Criminal> fetchCriminals() {
        // Wywołanie API FBI i pobranie danych
        return webClient.get()
                .uri(FBI_API_URL)
                .retrieve()
                .bodyToMono(String.class)
                .map(this::parseResponse)
                .block();
    }

    private List<Criminal> parseResponse(String responseBody) {
        // Parsowanie odpowiedzi JSON do listy obiektów Criminal
        try {
            JSONObject responseJson = new JSONObject(responseBody);
            JSONArray itemsJsonArray = responseJson.getJSONArray("items");
            List<Criminal> criminals = new ArrayList<>();

            for (int i = 0; i < itemsJsonArray.length(); i++) {
                JSONObject criminalJson = itemsJsonArray.getJSONObject(i);
                // Tworzenie obiektu Criminal na podstawie danych z JSON
                Criminal criminal = createCriminalFromJson(criminalJson);
                criminals.add(criminal);
            }

            return criminals;
        } catch (JSONException e) {
            throw new RuntimeException("Failed to parse response from FBI API", e);
        }
    }

    private Criminal createCriminalFromJson(JSONObject criminalJson) throws JSONException {
        // Tworzenie obiektu Criminal na podstawie danych z JSON
        Criminal criminal = new Criminal();
        criminal.setTitle(criminalJson.getString("title"));
        criminal.setCaution(criminalJson.getString("caution"));
        criminal.setDescription(criminalJson.getString("description"));

        return criminal;
    }

}
