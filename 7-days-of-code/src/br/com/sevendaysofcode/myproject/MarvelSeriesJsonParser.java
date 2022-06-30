package br.com.sevendaysofcode.myproject;

import java.util.ArrayList;
import java.util.List;

public class MarvelSeriesJsonParser implements JsonParser{
	
	private String json;

	public MarvelSeriesJsonParser(String json) {
		this.json = json;
	}

	private static String cut(String str) {
		String x = "                                                                                               ";
		return str.replace("\",\"",x+x+x).substring(0, 236).strip().toString();
	}

	private static String cutYear(String str) {
		String x = "                                                                                               ";
		return str.replace(",\"endYear",x+x+x).substring(0, 236).strip().toString();
	}

	@Override
	public List<Content> parse() {

		List<Content> list = new ArrayList<>();

		String[] titlesArray = json.split(",\"title\":\"");
		String[] urlsArray = json.split("path\":\"");
		String[] ratingsArray = json.split("\"rating\":\"");
		String[] yearsArray = json.split("startYear\":");

		for (int i = 1; i < titlesArray.length; i++) {
			String title = cut(titlesArray[i]);
			String url = cut(urlsArray[i]);
			String rating = cut(ratingsArray[i]);
			String year = cutYear(yearsArray[i]);
			if(rating.isBlank()) {
				rating = "Not found!";
			}

			list.add(new Series(title,url.concat(".jpg"),rating,year));
		}
		return list;		
	}

}
