package br.com.sevendaysofcode.myproject;

import java.math.BigInteger;
import java.security.MessageDigest;

public class CreateHashApiMarvel {
	
	public static String MD5(String stringToHash) {
		 try {
		        MessageDigest md = MessageDigest.getInstance("MD5");
		        byte[] messageDigest = md.digest(stringToHash.getBytes());
		        BigInteger number = new BigInteger(1, messageDigest);
		        String hashtext = number.toString(16);
		        while (hashtext.length()<32) {
		            hashtext = "0" + hashtext;
		        }
		        return hashtext;
		    } catch (Exception e) {
		        throw new RuntimeException(e);
		    }

		}

}
