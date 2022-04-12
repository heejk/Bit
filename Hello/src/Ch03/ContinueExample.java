package Ch03;

import java.util.Scanner;

public class ContinueExample {

	public static void main(String[] args) {
		int sum = 0;
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("5개의 정수를 입력하세요.");
		
		for (int i = 0; i < 5; i++) {
			int n = s.nextInt();
			
			if (n <= 0) // 양수가 아닌 0이나 음수인 경우 더하지 않고 다음 반복 
				continue;
			
			else // 양수인 경우 덧셈 
				sum += n;
		}
		
		System.out.println("양수의 합은 " + sum);
		
		s.close();
	}

}
