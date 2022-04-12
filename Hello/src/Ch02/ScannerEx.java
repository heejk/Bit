package Ch02;

import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		System.out.println("이름, 도시, 나이, 체중, 독신 여부를 빈칸으로 분리하여 입력하세요.");
		
		Scanner s = new Scanner(System.in);
		
		// 문자열 읽기 next()
		String name = s.next();
		System.out.println("당신의 이름은 " + name + "입니다.");
		
		String city = s.next();
		System.out.println("당신이 사는 도시는 " + city + "입니다.");
		
		// 정수형 읽기 nextInt()
		int age = s.nextInt();
		System.out.println("당신의 나이는 " + age + "살 입니다.");
		
		// 실수형 읽기 nextDouble()
		double weight = s.nextDouble();
		System.out.println("당신의 체중은 " + weight + "kg 입니다.");
		
		//불린형 읽기 nextBoolean()
		boolean single = s.nextBoolean();
		System.out.println("당신의 독신 여부는 " + single + "입니다.");
		
		s.close();
	}

}
