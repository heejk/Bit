package net.ex02.echo_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 클라이언트는 서버보다 훨씬 단순
 
 1) 서버의 주소(ip, port)를 가지고 소켓 생성 >> 생성자에서 connect 진행 
 2) 객체 생성 > 연결됨 > 통신 가능 
 3) 서버가 Echo 서버이므로 클라이언트가 보낸 데이터를 그대로 돌려줌
 4) close() 호출 > 연결된 스트림 해제 
 */
public class EchoClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// 서버에 접속한 소켓 생성 >> 127.0.0.1: loop address 외부망으로 나가지 말고 자신의 Host내에서 통신
		Socket clientSocket = new Socket("127.0.0.1", 9000);
		
		// 소켓 생성자에서 연결 스트림 생성 > 통신 가능 >> 서버에 전송할 문자열 입력받기 위해 입력 객체 생성
		InputStreamReader ink = new InputStreamReader(System.in);
		BufferedReader keyboard = new BufferedReader(ink);
	}

}
