package Ch02;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		// 돈의 액수를 입력받아 
		// 오만원권, 만원권, 천원권, 500원짜리 동전, 100원짜리 동전, 10원짜리 동전, 1원짜리 동전 
		// 각 몇 개로 변환되는지 출력하시오.
	
		Scanner s = new Scanner(System.in);
		
		System.out.print("액수를 입력하세요: ");
		int money = s.nextInt();

		// 50,000원 
		int m50000 = money / 50000;
		
		// 10,000원  
		money = money % 50000;
		int m10000 = money / 10000;
		
		// 1000원  
		money = money % 10000;
		int m1000 = money / 1000;
		
		// 500원 
		money = money % 1000;
		int m500 = money / 500;
		
		// 100원 
		money = money % 500;
		int m100 = money / 100;
		
		// 10원 
		money = money % 100;
		int m10 = money / 10;
		
		// 1원 
		money = money % 10;
		int m1 = money / 1;
		
		System.out.println("50,000원: " + m50000);
		System.out.println("10,000원: " + m10000);
		System.out.println("1,000원: " + m1000);
		System.out.println("500원: " + m500);
		System.out.println("100원: " + m100);
		System.out.println("10원: " + m10);
		System.out.println("1원: " + m1);
		
		s.close();
		
	}

}
