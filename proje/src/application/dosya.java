package application;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class dosya {

	public static void main(String[] args) throws IOException {
		Writer r = new FileWriter("kayýtlar.txt");
		r.write("Deneme1\n");
		r.write("Deneme2");
		r.close();
	}

}
