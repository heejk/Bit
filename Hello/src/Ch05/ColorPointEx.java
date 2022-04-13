package Ch05;

class Point {
	private int x, y;
	
	void set (int x, int y) { // 수퍼 클래스 
		this.x = x;
		this.y = y;
	}
	
	void showPoint() {
		System.out.println("(" + x + "," + y + ")");
	}
}

class ColorPoint extends Point { // 서브클래스 (Point 상속받음) 
	private String color;
	
	void setColor (String color) {
		this.color = color;
	}
	
	void showColorPoint() {
		System.out.print(color);
		showPoint();
	}
}

public class ColorPointEx {

	public static void main(String[] args) {
		Point p = new Point();
		p.set(1, 2);
		p.showPoint();
		
		ColorPoint cp = new ColorPoint();
		cp.set(3, 4);
		cp.setColor("red");
		cp.showColorPoint();
	}

}
