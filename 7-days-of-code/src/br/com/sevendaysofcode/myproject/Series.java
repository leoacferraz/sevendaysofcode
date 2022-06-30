package br.com.sevendaysofcode.myproject;

import static br.com.sevendaysofcode.myproject.CreateHashApiMarvel.MD5;

import java.time.LocalTime;

public record Series(String title, String urlImage, String rating, String year) implements Content, Comparable<Content> {
	
	static String ts = LocalTime.now().toString();
	static String publickey = "<insert your publicKey>";
	static String privatekey = "<insert your privateKey>";

	static String stringToHash = ts+privatekey+publickey;
	static String hash = MD5(stringToHash);


	static String getTs() {
		return ts;
	}

	static String getPublicKey() {
		return publickey;
	}

	static String getHash() {
		return hash;
	}
	
	@Override
	public String type() {
		return "Marvel Series";
	}
	
	@Override
	public int compareTo(Content outro) {
		return this.year().compareTo(outro.year());
	}

}
