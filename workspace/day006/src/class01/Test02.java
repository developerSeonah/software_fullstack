package class01;

// 반지름
// 넓이 = 반지름 * 반지름 * PI(3.14)
class Circle {
	String name;
	int radius;	// 반지름
	double area;	// 넓이
	// 클래스 변수
	static double PI = 3.14;	// 원주율
	
	// 객체 c1의 값을 변경해도,
	// 객체 c2의 값에 영향 x   ==> "객체와 무관하게" static
	// static을 붙이면 주인이 객체 x 클래스 o
	Circle(String name, int radius){
		// 생성자의 역할 : 
		this.name = name;
		this.radius = radius;
		this.area = this.radius*this.radius*Circle.PI;
	}
}

public class Test02 {
	public static void main(String[] args) {
		Circle c1 = new Circle("원01", 1);
		Circle c2 = new Circle("원02", 10);
		
		c1.PI = 2.1;
		System.out.println(c1.PI);
		System.out.println(c1.area);
		
		System.out.println("================");
		
		System.out.println(c2.PI);
		System.out.println(c2.area);
	}

}
