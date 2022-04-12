package Ch03;

public class ForEx01 {

	public static void main(String[] args) {
		int odd = 0, even = 0;
		
		for (int i=1; i<=100; i++) {
			if (i % 2 == 0)
				even += i;
			else
				odd += i;
		}
		
		System.out.println("짝수 합: " + even);
		System.out.println("홀수 합: " + odd);
	}

}
