package class01;

import java.util.Scanner;

class Point{
	// 멤버 변수
	int x;
	int y;
	
	// 생성자
	Point(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("부모 생성자 호출 됨");
	}
	
	// 함수
	void move() {
		move(1);
	}
	void move(int x) {
		this.x += x;
		this.y += x;
	}
	void printInfo() {
		System.out.println("("+this.x+", "+this.y+")");
	}
}

class ColorPoint extends Point{
	// 멤버변수
	String color;
	
	// 생성자
	ColorPoint(int x, int y, String color){
		super(x, y);
		this.color = color;
	}

	@Override
	void printInfo() {
		System.out.println(this.color+" ("+this.x+", "+this.y+")");
	}

}

public class Test01 {
	public static void main(String[] args) {		
		// 유효성 검사는 생략
		
		Scanner sc = new Scanner(System.in);
		Point[] datas = new Point[3];
		
		// 샘플 데이터
		datas[0] = new Point(1, 2);
		datas[1] = new ColorPoint(1, 2, "파랑");
		
		int cnt = 2; // 현재 저장된 점의 개수
		
		while(true) {
			System.out.println("1. 점 추가");
			System.out.println("2. 전체 점 목록 출력");
			System.out.println("3. 점 움직이기");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 입력 >>");
			int menu = sc.nextInt();
			
			if(menu == 0) {
				break;
			}
			else if(menu == 1) {
				System.out.println("1. 점");
				System.out.println("2. 색깔점");
				System.out.print("번호 입력 >> ");
				int num = sc.nextInt();
				
				if(num == 1) {		// 일반 점일 때
					System.out.print("x좌표 입력 >> ");
					int x = sc.nextInt();
					System.out.print("y좌표 입력 >> ");
					int y = sc.nextInt();
					datas[cnt++] = new Point(x, y);
				}
				else if(num == 2) {		// 색깔점일 때
					System.out.print("x좌표 입력 >> ");
					int x = sc.nextInt();
					System.out.print("y좌표 입력 >> ");
					int y = sc.nextInt();
					System.out.print("색깔 입력 >> ");
					String color = sc.next();
					datas[cnt++] = new ColorPoint(x, y, color);
				}
			}
			else if(menu == 2) {
				for(int i = 0; i < cnt; i++) {
					datas[i].printInfo();
					// 점 객체가 printInfo()를 수행합니다.
					// 점 ----> (x, y)
					// 색깔점 ----> 색(x, y)
					// "동적바인딩"이 발생했다.
					// "다현성"을 실힝할 수 있다.
					//  == 똑같은 메서드를 수행시키더라도
		            //     메서드 수행 주체가 어떤 객체냐인지에따라
		            //     다른 메서드가(오버라이딩된 메서드가) 수행되는 것
				}
			}
		}
	}
}