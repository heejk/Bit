package fileio.ex03.data_filter_stream;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DataFilterStream {

	public static void main(String[] args) throws IOException {
		// 1단계
		OutputStream out = new FileOutputStream("MyData.bin");
		
		// 출력 스트림 객체와 결합하는 필터 스트림 객체 생성
		DataOutputStream filterOut = new DataOutputStream(out);
		
		// 2단계
		filterOut.writeInt(365);
		filterOut.writeDouble(3.14);
		
		// 3단계
		filterOut.close();
		
		// 위에서 저장한 정수값과 실수값 다시 읽어보기
		InputStream in = new FileInputStream("MyData.bin");
		DataInputStream filterIn = new DataInputStream(in);
		
		int num = filterIn.readInt();
		double dNum = filterIn.readDouble();
		
		filterIn.close();
		
		System.out.println("int = " + num);
		System.out.println("double = " + dNum);
	}

}
