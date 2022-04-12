package Ch02;

public class Operator {

	public static void main(String[] args) {
		int x = 2, y = 10, z = 0;
		
		z = x++ * 2 + --y - 5 + x * (y % 2);	// 4 + 9 - 5 + 3
		
		System.out.println("z = " + z);
		
		System.out.println(8 >> 2);
		
		int opr = 4;
		System.out.println(opr++); 	// 4
		System.out.println(opr); 	// 5
	}

}
