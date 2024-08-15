package class02;

abstract class Shape{
	private String name;
	protected double area;
	
	Shape(String name){
		this.name = name;
		this.area = 1;
	}
	
	// 메서드는 쓰라고 만든 것이므로
	// public 공개 정책
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	
	// abstract이 붙은 메소드 == 추상 메소드
	// "오버라이딩 강제"하는 역할 ★
	// 기능의 내용이 필요없기 때문에,
	// {} 메서드 바디가 필요없음
	abstract public void draw();	
}

class Circle extends Shape{
	private int radius;
	static final double PI = 3.14;

	public int getRadius() {
		return radius;
	}

	Circle(int radius){
		super("원");
		this.radius = radius;
		this.area = this.radius * this.radius * Circle.PI;
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void draw() {
		System.out.println("원 그리기");
		
	} 
	
}

public class Test01 {
	public static void main(String[] args) {
		
//		Shape s = new Shape("모양");
		// 추상 클래스로는 객체화(인스턴스화) 할 수 없음
		// 객체를 생성하려고 존재하는게 아니라,
		// 클래스들을 정의하려고 존재하기 때문에
		//  == 클래스들의 틀
		
		Circle c = new Circle(10);
		System.out.println("원의 넓이 : " + c.getArea());
	}

}
