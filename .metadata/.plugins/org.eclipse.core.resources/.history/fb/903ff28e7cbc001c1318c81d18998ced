package net.ex08.cmd_packet_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class CmdPacketClient {

	final static String IP = "127.0.0.1";
	final static int PORT = 9000;
	
	public static void main(String[] args) {
		try {
			Socket socket = new Socket(IP, PORT);
			
			InputStreamReader inK = new InputStreamReader(System.in);
			BufferedReader keyboard = new BufferedReader(inK);
			
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter outW = new OutputStreamWriter(out);
			PrintWriter pw = new PrintWriter(outW);
			
			InputStream in = socket.getInputStream();
			InputStreamReader inR = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inR);
			
			while (true) {
				System.out.print("input operator (+ - * / quit) >> ");
				String cmd = keyboard.readLine();
				
				if (cmd.equals("quit")) {
					System.out.println("Client Ended !");
					break;
				}
				
				System.out.print("Input First Number >> ");
				int num1 = Integer.parseInt(keyboard.readLine());
				
				System.out.print("Input Second Number >> ");
				int num2 = Integer.parseInt(keyboard.readLine());
				
				// 패킷 구성
				String packet = String.format("%s|%d|%d", cmd, num1, num2);
				System.out.println("Send Packet: " + packet);
				
				pw.println(packet);
				pw.flush();
				
				// 결과값 수신
				String result = br.readLine();
				System.out.println("Result = " + result);
			}
			
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
