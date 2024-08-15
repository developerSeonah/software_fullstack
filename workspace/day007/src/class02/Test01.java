package class02;
//상속

class Point{
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("부모 생성자 호출됨");
	}
	
	void printInfo() {
		System.out.println("("+this.x+", "+this.y+")");
	}
	void move(){
		this.x++;
		this.y++;
	}
}

class ColorPoint extends Point{
	String color;
	
	ColorPoint(String color, int x, int y) {
		// 자식 클래스의 모든 생성자들은 
		// 가장먼저 호출하는 것이 있다.
		// 부모 클래스의 기본 생성자를 호출
		// 1. 부모 클래스에 기본 생성자를 선언(정의) (x)
		//		=> 먼저 작성된 코드를 나중에 작성되는 코드 때문에 변경한다>
		//		=> 대부분 잘못된 해결방식...!!
		//	: 기본 생성자를 사용하지않는 이유는 "강제"
		//	  기본 생성자를 만들어버린다? 강제성을 잃게 됨
		// 2. 부모 클래스에 존재하는 다른 생성자를 대신 사용 o
		//		부모를 super라고 부름
		super(x,y);
		// 자식 클래스의 객체를 만들 때에는
		// 부모 클래스의 생성자 선 호출 --> 자식 클래스 생성자 호출
		this.color = color;
		System.out.println("자식 생성자 호출됨");
	}
}

public class Test01 {
	public static void main(String[] args) {
		Point p1 = new Point(10,10);
		p1.printInfo();
		p1.move();
		p1.printInfo();
		
		ColorPoint p2 = new ColorPoint("초록", 1, 2);
		p2.printInfo();
		p2.move();
		p2.printInfo();
	}

}
