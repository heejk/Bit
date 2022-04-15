package net.ex03.file_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 1. 클라이언트가 서버에 파일 요청 (파일 이름 전송)
 2. 서버는 해당 파일을 연결한 후 클라이언트에 전송
 3. 전송 후 통신 해제 
 */

public class FileServer {

	public static void main(String[] args) {
		try {
			// 접속 대기 소켓 생성 
			ServerSocket serverSocket = new ServerSocket(9000);
			
			// 클라이언트 접속 대기 후 소켓 연결 
			System.out.println("Wait client...");
			Socket conSocket = serverSocket.accept();
			System.out.println("Connect client !");
			
			// 소켓을 통해 양방향 stream 얻기
			InputStream in = conSocket.getInputStream();
			DataInputStream dIn = new DataInputStream(in);
			
			OutputStream out = conSocket.getOutputStream();
			DataOutputStream dOut = new DataOutputStream(out);
			
			// 클라이언트가 요청하는 파일명 수신
			String fileName = dIn.readUTF();
			System.out.println("Request File: " + fileName);
			
			// 요청 파일 연결
			FileInputStream fIn = new FileInputStream(fileName);
			
			// 요청 파일을 클라이언트에 전송
			int cnt = 0;
			while (true) {
				int data = fIn.read();
				
				if (data == -1) {
					System.out.println("Send Complete !");
					break;
				}
				
				System.out.println("Sending..." + cnt++);
				dOut.write(data);
			}
			
			// 전송 후 파일/통신 스트림 해제
			fIn.close();
			dIn.close();
			dOut.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
