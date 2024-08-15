package class05;

// 포인트 클래스
class Point{
	// 멤버변수
	int x;	// x좌표
	int y;	// y좌표
	
	// 생성자
	// x = y 좌표일 때
	Point(int x){
		this(x,x);
	}
	// x, y 둘 다 입력
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	// 함수
	// 좌표값을 출력하는 함수
	void printInfo() {
		System.out.println("("+this.x+", "+this.y+")");
	}
}

// 컬러 포인트 클래스
class ColorPoint extends Point{
	// 멤버변수
	String color;		// 색
	
	// 생성자
	// 색, x = y 일 때 입력
	ColorPoint(int x){
		this(x, x);		// 기본색은 검정
	}
	// x, y 입력
	ColorPoint(int x, int y){
		this("검정", x, y);	// 기본색을 검정으로
	}
	// 색, x = y 일 때 입력
	ColorPoint(String color, int x){
		this(color, x, x);
	}
	// 색, x, y 다 입력
	ColorPoint(String color, int x, int y){
		super(x, y);
		this.color = color;
	}
	
	// 함수
	@Override
	void printInfo() {
		System.out.println(this.color+"("+this.x+", "+this.y+")");
	}
}

public class Task01 {
	public static void main(String[] args) {
		
		// Point 객체 생성, 좌표 출력
		Point p = new Point(2, 3);
		p.printInfo();
		
		System.out.println();
		
		// ColorPoint 객체 생성, 좌표 출력
		ColorPoint cp = new ColorPoint("분홍", 4, 5);
		cp.printInfo();
	}

}
