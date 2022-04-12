package Ch03;

import java.util.Scanner;

public class ForEx02 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("출력할 단을 입력하세요(1~9): ");
		int num = s.nextInt();
		
		for (int i = 1; i < 10; i++) 
			System.out.println(num + "*" + i + "=" + num * i);
		
	}
}
