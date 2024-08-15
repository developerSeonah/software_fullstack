package class03;

// 부모 클래스
class Shape{
	// 멤버변수
	String name;	// 모양의 이름
	double area;	// 넓이
	String color;	// 색
	
	// 생성자 (강제 : 이름)
	// 이름
	Shape(String name){
		// 기본 색은 검정
		this(name, "검정색");
		//System.out.println("로그 01");
	}
	// 이름, 색
	Shape(String name, String color){
		// 기본 넓이는 1.0
		this.name = name;	// 이름은 반드시 있다.
		this.area = 0.0;	
		this.color = color;
		//System.out.println("로그 02");
	}
	
	// 함수
	void draw() {
		// 색, 이름, 넓이 출력
		System.out.println(this.color+" "+ this.name+"모양 "+this.area+"만큼의 넓이");
	}
	void setArea() {
		// 넓이를 설정하는 메서드
		System.out.println("Shape에서 호출한 SetArea()");
	}
}

// 자식 클래스
// 원
class Circle extends Shape{
	// 멤버변수
	int radius;	// 반지름
	final static double PI = 3.14;	// 클래스 변수, 상수 PI
	
	// 생성자
	// 이름만 생성
	Circle(){
		this(1);	// 기본 반지름은 1
	}
	// 이름, 컬러
	Circle(String color){
		this(1,color);	// 기본 반지름은 1
	}
	// 이름, 반지름
	Circle(int radius){
		this(radius,"검정색");
	}
	// 반지름, 컬러 생성
	Circle(int radius, String color){
		//부모 클래스에서 선언할 수 있는 생성자먼저 생성
		super("원",color);	//부모와 자식 공통으로 생성하는 name 생성
		this.radius = radius;
		this.area = this.radius * this.radius * PI;
	}
}

// 사각형
class Rectangle extends Shape{
	int x;	// 가로
	int y;	// 세로
	
	// 생성자
	Rectangle(){
		this(1);
	}
	// 정사각형
	Rectangle(int x){
		this(x, "검정색");
	}
	// 정사각형, 색
	Rectangle(int x, String color){
		super("정사각형", color);
		this.x = x;
		this.y = x;
		this.area = this.x*this.y;
	}
	// 가로, 세로
	Rectangle(int x, int y){
		this(x, y, "검정색");
	}
	// 가로, 세로, 색
	Rectangle(int x, int y, String color){
		super("직사각형", color);
		this.x = x;
		this.y = y;
		this.area = this.x*this.y;
	}	
}

public class Test01 {
	public static void main(String[] args) {
		
		System.out.println("원 모양");
		Circle c1 = new Circle();
		c1.draw();
		System.out.println();
		
		Circle c2 = new Circle("파란색");
		c2.draw();
		System.out.println();
		
		Circle c3 = new Circle(10);
		c3.draw();
		System.out.println();
		
		Circle c4 = new Circle(15, "초록색");
		c4.draw();
		System.out.println();
		
		System.out.println("사각형 모양");
		Rectangle r1 = new Rectangle();
		r1.draw();
		System.out.println();
		
		Rectangle r2 = new Rectangle(4);
		r2.draw();
		System.out.println();
		
		Rectangle r3 = new Rectangle(2, 3);
		r3.draw();
		System.out.println();
		
		Rectangle r4 = new Rectangle(3, "초록색");
		r4.draw();
		System.out.println();
		
		Rectangle r5 = new Rectangle(2, 2, "보라색");
		r5.draw();
		System.out.println();
		
		
	}

}
