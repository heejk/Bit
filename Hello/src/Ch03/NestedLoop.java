package Ch03;

public class NestedLoop {

	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) { // 1단 ~ 9단 
			for (int  j = 1; j < 10; j++) { // 각 단의 곱셈 
				System.out.print(i + "*" + j + "=" + i * j);
				System.out.print('\t'); 
			}
			
			System.out.println(); // 각 단이 끝날 때마다 줄바꿈 
		}
	}

}
