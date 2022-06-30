package br.com.sevendaysofcode.myproject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MarvelSeriesApiClient implements APIClient {
	
	private String ts;
	private String publicKey;
	private String hash;

	public MarvelSeriesApiClient(String ts,String apiKey, String hash) {
		this.ts = ts;
		this.publicKey = apiKey;
		this.hash = hash;
	}

	@Override
	public String getBody() throws Exception {
		URI apiIMDB = URI.create("https://gateway.marvel.com:443/v1/public/series?limit=50&ts="
		+ this.ts + "&apikey=" + this.publicKey + "&hash=" + this.hash);

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(apiIMDB).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		return response.body();
	}

}
