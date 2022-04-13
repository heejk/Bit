package Ch06;

public class WrapperEx {

	public static void main(String[] args) {
		//Character
		System.out.println(Character.toLowerCase('A'));
		
		char c1 = '4', c2 = 'F';
		
		if (Character.isDigit(c1))
			System.out.println(c1 + "는 숫자");
		if (Character.isAlphabetic(c2))
			System.out.println(c2 + "는 영문자");
		
		// Integer
		System.out.println(Integer.parseInt("28"));
		System.out.println(Integer.toString(28));
		System.out.println(Integer.toBinaryString(28));
		System.out.println(Integer.bitCount(28));
		
		Integer i = new Integer(28);
		System.out.println(i.doubleValue());
	}

}
