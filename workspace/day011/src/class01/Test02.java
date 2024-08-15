package class01;

// 반지름
// 넓이 = 반지름 * 반지름 * PI(3.14)
class Circle {
	// 멤버 변수
	private String name;
	private int radius; // 반지름
	private double area; // 넓이   
	
	// 클래스 변수
	static final double PI=3.14; // 원주율
	// 객체 c1의 값을 변경해도,
	// 객체 c2의 값에 영향 xxx ===>> "객체와 무관하게" static
	// 주인이 객체 x 클래스 O
	Circle(String name,int radius){
		// 생성자의 역할 : 멤버변수 초기화
		this.name=name;
		this.radius=radius;
		this.area=this.radius*this.radius*Circle.PI;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}

}

public class Test02 {
   public static void main(String[] args) {
      Circle c1=new Circle("원01",1);
      Circle c2=new Circle("원02",10);
            
      System.out.println(Circle.PI);
      System.out.println(c1.getArea());
      
      System.out.println("==========");
      
      System.out.println(c2.PI);
      System.out.println(c2.getArea());
      
   }
}
