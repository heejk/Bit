package net.ex06.multi_thread_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoLoopClient {
	
	final static String IP = "127.0.0.1";
	final static int PORT = 9000;
	
	public static void main(String[] args) {
		try {
			// 소켓 생성과 동시에 서버와 연결 
			Socket clientSocket = new Socket(IP, PORT);
			
			// 키보드 입력받을 스트림 생성 
			InputStreamReader inK = new InputStreamReader(System.in);
			BufferedReader keyboard = new BufferedReader(inK);
			
			// 서버와 연결된 양방향 스트림 얻기
			OutputStream out = clientSocket.getOutputStream();
			OutputStreamWriter outW = new OutputStreamWriter(out);
			PrintWriter pw = new PrintWriter(outW);
			
			InputStream in = clientSocket.getInputStream();
			InputStreamReader inR = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inR);
			
			// 사용자로부터 데이터 입력 > 서버로 전송 > 서버로부터 echo 수신 > quit 입력 전까지 반복
			while (true) {
				System.out.print("input >> ");
				String line = keyboard.readLine();
				
				if (line.equals("quit")) {
					System.out.println("Client Quit !");
					break;
				}
				
				System.out.println("Send Server: " + line);
				pw.println(line);
				pw.flush();
				
				String echo = br.readLine();
				System.out.println("Received From Server: " + echo);
			}
			
			// 스트림 종료
			keyboard.close();
			pw.close();
			br.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
