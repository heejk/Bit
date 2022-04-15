package fileio.ex02.buffer_file_copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 파일 입출력 3단계 동일
 but, 읽거나 저장할 때 일정 크기 이상 많이 시도
 >> 속도 개선 
 */

public class BufferFIleCopy {

	public static void main(String[] args) throws IOException {
		// 1단계 stream open
		InputStream in = new FileInputStream("putty.exe");
		OutputStream out = new FileOutputStream("futty.exe");
		
		int copyByte = 0; // 전체 몇 byte 읽었는가 ? (기록)
		int readLen = 0; // 한 번 읽을 때 얼마나 읽는가 ?
		byte[] buf = new byte[1024]; // 파일을 한 번에 읽어들일 저장소
		
		long sTime = System.currentTimeMillis();
		
		// 2단계 stream read / write
		while (true) { 
			// buf 크기만큼 읽기 시도
			readLen = in.read(buf); // 실제 읽은 크기는 readLen에 저장
			
			if (readLen == -1)
				break;
			
			// 배열의 시작 위치(인덱스 0)에서부터 readLen 크기만큼 저장 
			out.write(buf, 0, readLen);
			copyByte += readLen;
			System.out.println("coopyByte = " + readLen);
		}

		
		long eTime = System.currentTimeMillis();
		
		// 3단계 stream close
		in.close();
		out.close();
		
		System.out.println("Copy Bytes: " + copyByte);
		System.out.println("Copy Times: " + (eTime - sTime));
	}

}
