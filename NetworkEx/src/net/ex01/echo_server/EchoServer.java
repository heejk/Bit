package net.ex01.echo_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 서버: 서비스를 제공하는 프로세스
 
  TCP > UDP
  0) 소켓 생성 (접속할 전화기 필요)
  1) 고정된 주소를 가짐 (bind - 전화기에 전화번호 부여)
  2) 접속 요청하는 클라이언트를 받아줘야 함 (accept)
  3) 요청을 받아들이면 송수신 스트림 개통
  4) 스트림 개통 > 통신 가능
  5) close() 호출 > 스트림 해제
*/

public class EchoServer {

	public static void main(String[] args) throws IOException {
		// 소켓 생성 >> ip/port 필요 >> ip: 현재 Host의 ip 자동할당 / port: 정해줘야 함 (9000)
		ServerSocket serverSocket = new ServerSocket(9000);
		
		// 클라이언트 접속 대기 >> accept() 호출하면 클라이언트 접속 연결시 클라이언트와 연결된 새로운 연결소켓 반환 
		System.out.println("Wait client...");
		Socket conSocket = serverSocket.accept();
		
		// 상대방 연결정보 확인
		InetAddress inetAddr = conSocket.getInetAddress();
		System.out.println(inetAddr.getHostAddress() + " connect !");
		
		// 전송 스트림 (연결소켓으로 통신 가능)
		OutputStream out = conSocket.getOutputStream();
		OutputStreamWriter outW = new OutputStreamWriter(out);
		PrintWriter pw = new PrintWriter(outW);
		
		// 수신 스트림
		InputStream in = conSocket.getInputStream();
		InputStreamReader inR = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(inR);
		
		// 송수신
		while (true) {
			// 클라이언트가 보내는 데이터를 기다리다가 도착하면 문자열 반환 
			String line = br.readLine();
			
			// 만약 데이터를 기다리다가 null이 반환되었다면 연결이 끊어진 것
			if (line == null) {
				System.out.println("Client Disconnect !");
				break;
			}
			
			System.out.println("Received: " + line);
			
			pw.println(line); // 클라이언트에 그대로 돌려줌
			pw.flush(); // 버퍼에 저장된 데이터를 즉시 전송 
		}
		
		// 스트림 종료
		pw.close();
		br.close();
		System.out.println("client - server Ended !");
	}

}
