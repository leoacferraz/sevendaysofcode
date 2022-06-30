package br.com.sevendaysofcode.myproject;

import java.io.BufferedWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Catalog {

	public static void main(String[] args) throws Exception {
		
		APIClient client1 = new ImdbApiClient(Movie.getApiKey());
		APIClient client2 = new MarvelSeriesApiClient(Series.getTs(), Series.getPublicKey(), Series.getHash());

		JsonParser body1 = new ImdbMovieJsonParser(client1.getBody());
		JsonParser body2 = new MarvelSeriesJsonParser(client2.getBody());

		BufferedWriter bw =  FileWriter.write("index.html");
		
		List<Content> moviesList = body1.parse();
		List<Content> seriesList = body2.parse();
		
		List<Content> mixedList = Stream.of(moviesList,seriesList)
		.flatMap(Collection::stream)
		.collect(Collectors.toList());
		
		Collections.sort(mixedList,Comparator.comparing(Content::title));
		
		new HTMLGenerator(bw).generate(mixedList);

		bw.close();

	}

}
