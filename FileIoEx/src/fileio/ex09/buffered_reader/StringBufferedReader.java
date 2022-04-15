package fileio.ex09.buffered_reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class StringBufferedReader {

	public static void main(String[] args) throws IOException {
		Reader in = new FileReader("String.txt");
		BufferedReader bIn = new BufferedReader(in);
		
		while (true) {
			String str = bIn.readLine();
			
			if (str == null) 
				break;
			
			System.out.println(str);
		}
		
		in.close();
		
	}

}
