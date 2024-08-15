package class02;

class Point{
	int x;
	int y;
	
	//생성자 오버로딩
	Point(){
		this(0);
		System.out.println("로그01");
	}
	Point(int x){
		this(x,x); 	//생성자 함수 호출
		System.out.println("로그02");
	}
	Point(int x, int y){
		this.x = x;
		this.y = y;
		System.out.println("로그03");
	}
	// 코드 재사용
	// 1. 가장 인자가 많은 생성자 함수를 먼저 구현하고,
	// 2. 나머지 생성자 함수가 1을 재사용한다.
	
	//오버로딩
	void move() {
		this.x++;
		this.y++;
	}
	void printInfo() {
		System.out.println("x : "+this.x+", y : "+ this.y);
	}
}

public class Test01 {
	public static void main(String[] args) {
		Point p1 = new Point();
		System.out.println("--------------");
		Point p2 = new Point(10);
		System.out.println("--------------");
		Point p3 = new Point(1,2);
		System.out.println("--------------");
		
		p3.move();
		p3.printInfo();
	}
}