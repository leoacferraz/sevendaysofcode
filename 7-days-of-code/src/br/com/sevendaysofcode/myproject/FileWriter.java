package br.com.sevendaysofcode.myproject;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class FileWriter {
	
	public static BufferedWriter write(String name) throws Exception {
		FileOutputStream fos = new FileOutputStream(name);
		Writer osw = new OutputStreamWriter(fos);
		return new BufferedWriter(osw);
	}

}
