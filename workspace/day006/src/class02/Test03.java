package class02;
/*
1. 현재속도는 반드시 0으로 시작
2. 최고속도를 지정해주지않으면 기본값 120
3. 차주 이름은 등록하지 않으면 "무명"으로 저장됨
4. speedUp() -> 속도 50증가
5. speedDown -> 속도 100감소
+) speedUP(값) -> 해당 값만큼 속도 증가
 */

class Car{
	String name;
	int speed;		// 현재 속도
	int maxSpeed;	// 최고 속도
	
	// 전부 초기값
	Car(){
		// 기본값 무명, 120
		this("무명");
	}
	// 이름만 등록
	Car(String name){
		//최고속도를 지정해주지않으면 기본값 120
		this(name,120);
	}
	// max스피드만 등록
	Car(int maxSpeed){
		// 차주 이름은 등록하지 않으면 "무명"으로 저장됨
		this("무명",maxSpeed);
	}
	// 가장 먼저 제작, 모든 매개변수 초기화
	Car(String name, int maxSpeed){
		this.name = name;
		this.speed = 0;		//현재속도는 반드시 0으로 시작
		this.maxSpeed = maxSpeed;
	}
	
	void speedUp() {
		// speedUp() -> 속도 50증가
		// speedUp(값)과 중복되므로 함수 사용
		this.speedUp(50);	// 대체로 이런 일은 없음
		
	}
	void speedUp(int speedUp) {
		//speedDown -> 속도 100감소
		this.speed += speedUp;
		
		// 만약 현재 스피드가 최대 속도보다 높다면
		if(this.speed > this.maxSpeed) {
			// 속도를 최대 속도로 변경
			this.speed = this.maxSpeed;
		}
		System.out.println("속도를 "+ speedUp+"만큼 높임");
	}
	void speedDown() {
		// speedDown -> 속도 100감소
		this.speed -= 100;
		
		// 만약 현재 스피드가 0보다 낮다면
		if(this.speed < 0) {
			// 속도를 0으로 변경
			this.speed = 0;
		}
		System.out.println("속도를 100만큼 줄임");
	}
	void printInfo() {
		System.out.println("이름 : " + this.name);
		System.out.println("속도 " + this.speed);
		System.out.println("최고 : " + this.maxSpeed);
		System.out.println("-----------------");
	}
}

public class Test03 {
	public static void main(String[] args) {
//		Car c1 = new Car();
//		c1.printInfo();
//		System.out.println("-----------------");
//		
//		Car c2 = new Car("JJH");
//		c2.printInfo();
//		System.out.println("-----------------");
//		
//		Car c3 = new Car(150);
//		c3.printInfo();
//		System.out.println("-----------------");
//		
		Car c4 = new Car("JJH", 150);
		c4.printInfo();
		
		c4.speedUp();
		c4.printInfo();
		
		c4.speedUp(80);
		c4.printInfo();
		
		c4.speedDown();
		c4.printInfo();
	}
}