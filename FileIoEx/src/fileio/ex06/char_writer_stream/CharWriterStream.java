package fileio.ex06.char_writer_stream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/* 
 1단계 스트림 생성  // 단, 문자열 형식에 맞는 클래스 객체 생성  
 2단계 입출력
 3단계 스트림 닫기  
*/

public class CharWriterStream {

	public static void main(String[] args) throws IOException {
		// 1단계
		Writer out = new FileWriter("My.txt");
		
		// 2단계
		out.write('A');
		out.write('B');
		out.write("HongGilDong");
		
		// 3단계 
		out.close();
	}

}
