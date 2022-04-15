package fileio.ex10.print_writer_stream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

public class PrintWriterStream {

	public static void main(String[] args) throws IOException {
		Writer out = new FileWriter("print.txt");
		BufferedWriter bOut = new BufferedWriter(out);
		PrintWriter pOut = new PrintWriter(bOut);
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("What's Your Name >> ");
		String name = s.next();
		
		System.out.print("What's Your Age >> ");
		int age = s.nextInt();
		
		System.out.print("What's Your Height >> ");
		float height = s.nextFloat();
		
		System.out.print("What's Your Weight >> ");
		float weight = s.nextFloat();
		
		pOut.print("My Name is " + name + "\n");
		pOut.println();
		pOut.println();
		pOut.printf("My Age is %d\n", age);
		pOut.printf("My Height is %.1f\n", height);
		pOut.printf("My Weight is %.1f\n", weight);
		
		
		pOut.close();
		s.close();
	}

}
