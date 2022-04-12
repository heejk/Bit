package Ch03;

public class ForSample {

	public static void main(String[] args) {
		int i, sum = 0;
		
		for (i = 1; i <= 10; i++) {
			sum += i;
			System.out.print(i); // 더하는 수 
			
			if (i <= 9)
				System.out.print("+");
			else { // i = 10
				System.out.print("=");
				System.out.print(sum);
			}
		}
	}

}
