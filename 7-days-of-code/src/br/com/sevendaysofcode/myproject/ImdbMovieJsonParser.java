package br.com.sevendaysofcode.myproject;

import java.util.ArrayList;
import java.util.List;

public class ImdbMovieJsonParser implements JsonParser{
	
	private String json;

	public ImdbMovieJsonParser(String json) {
		this.json = json;
	}

	private static String cut(String str) {
		String x = "                                                                                               ";
		return str.replace("\",\"",x+x+x).substring(0, 236).strip().toString();
	}

	@Override
	public List<Content> parse() {

		List<Content> list = new ArrayList<>();

		String[] titlesArray = json.split(Parameter.TITLE.regex());
		String[] urlsArray = json.split(Parameter.IMAGE.regex());
		String[] ratingsArray = json.split(Parameter.RATING.regex());
		String[] yearsArray = json.split(Parameter.YEAR.regex());

		for (int i = 1; i < titlesArray.length; i++) {
			String title = cut(titlesArray[i]);
			String url = cut(urlsArray[i]);
			String rating = cut(ratingsArray[i]);
			String year = cut(yearsArray[i]);
			list.add(new Movie(title,url,rating,year));
		}
		return list;		
	}
	
	

}
