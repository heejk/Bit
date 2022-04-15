package fileio.ex07.char_reader_stream;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CharReaderStream {

	public static void main(String[] args) throws IOException {
		// 1단계
		Reader in = new FileReader("My.txt");
		
		// 2단계
		char[] cBuf = new char[20];
		int readCnt = 0;

		readCnt = in.read(cBuf, 0, cBuf.length);
		
		String str = new String(cBuf);
		
		System.out.println(str);
		System.out.println("read Bytes: " + readCnt);
		
		// 3단계
		in.close();
	}

}
