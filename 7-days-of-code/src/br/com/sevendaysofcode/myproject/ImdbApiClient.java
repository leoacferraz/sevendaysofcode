package br.com.sevendaysofcode.myproject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImdbApiClient implements APIClient {
	
	private String apiKey;

	public ImdbApiClient(String apiKey) {
		this.apiKey = apiKey;
	}

	@Override
	public String getBody() throws Exception {
		URI apiIMDB = URI.create("https://imdb-api.com/en/API/Top250Movies/" + apiKey);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(apiIMDB).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();
	}

}
