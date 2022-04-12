package Ch03;

public class ReturnArray {

	static int[] makeArray() {
		int temp[] = new int[4]; // makeArray()가 종료해도 생성된 배열은 소멸되지 않음 
		
		for (int i = 0; i < temp.length; i++) // length = 4
			temp[i] = i; // 0, 1, 2, 3
		
		return temp; 
	}
	
	public static void main(String[] args) {
		int intArray[] = makeArray(); 
		
		for (int i = 0; i < intArray.length; i++)
			System.out.print(intArray[i] + " ");
		
	}

}
