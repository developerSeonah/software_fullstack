package class01;

// 상품 Product
class Product{
	int num;	// PK
	String name;
	int cnt;	// 재고
	int price;
	
	// 생성자 오버로딩
	Product(int num, String name){
		this.num = num;		// 시스템에서 부여하는 값
		this.name = name;	// 상품명
		this.cnt = 0;
		this.price = 0;
	}

	Product(int num, String name, int cnt, int price){
		this.num = num;		// 시스템에서 부여하는 값
		this.name = name;	// 상품명
		this.cnt = cnt;
		this.price = price;
	}
}

public class Test01 {
	
	// 오버로딩
	// 메처드 시그니쳐가 다르다면 메소드명이 같더라도 이를 허용한다는 특징
	// 함수명 중복 정의 허용
	// 비슷하거나 유사하거나 같은 기능일 때 사용
	public static int plus(int a, int b) {
		System.out.println("1");
		return a+b;
	}
	public static int plus(int a, int b, int c) {
		System.out.println("2");
		return a+b+c;
	}
	public static double plus(double a, double b) {
		System.out.println("3");
		return a+b;
	}
	public static double plus(double a, double b, double c) {
		System.out.println("4");
		return a+b+c;
	}

	
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int c = 30;
		double d = 1.5;
		
		
		System.out.println(plus(a,b));
		System.out.println(plus(a,b,c));
		System.out.println(plus(d,d));
		
		//println()이라는 함수가 '오버로딩'되었기 때문
		System.out.println(10);
		System.out.println(3.14);
		
		Product p1=new Product(1001,"운동화");
	     Product p2=new Product(1002,"우산",10,4000);

		
		
	}

}
