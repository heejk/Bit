package Ch02;

import java.util.Scanner;

public class SwitchEx {

	public static void main(String[] args) {
		char grade;
		
		Scanner s = new Scanner(System.in);

		System.out.print("점수를 입력하세요(0~100): ");
		int score = s.nextInt();
		score = score * 10 / 100;
		
		switch(score) {
		case 10:
		case 9:
			grade = 'A';
			System.out.println("학점: " + grade);
			break;
		case 8:
			grade = 'B';
			System.out.println("학점: " + grade);
			break;
		case 7:
			grade = 'C';
			System.out.println("학점: " + grade);
			break;
		case 6:
			grade = 'D';
			System.out.println("학점: " + grade);
			break;
		}
	}

}
