package br.com.sevendaysofcode.myproject;

public record Movie(String title, String urlImage, String rating, String year) implements Content, Comparable<Content> {
	
	static String apiKey = "<insert your apiKey>";

	static String getApiKey() {
		return apiKey;
	}
	
	@Override
	public String type() {
		return "Movie";
	}
	
	@Override
	public int compareTo(Content outro) {
		return this.year().compareTo(outro.year());
	}

}
