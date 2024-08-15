package class06;

import java.util.Random;

// 학생 클래스
// 멤버 변수 : 이름, 성적(정수)
// 생성자 : 이름 "강제"
//		  생성 시 성적이 랜덤으로 저장
// 함수 : hello()
//			이름 성적을 화면에 출력

class Student01{
	// 멤버 변수 : 이름, 성적(정수)
	String name;
	int score;
	
	//생성자 선언
	//	이름 "강제"
	//	생성 시 성적 랜덤 저장
	Student01(String name){
		this.name = name;
		Random rand = new Random();
		this.score = rand.nextInt(101);
	}
	
	// 함수 : hello()
	//	이름 성적을 화면에 출력
	void hello() {
		System.out.println("이름 : "+ this.name);
		System.out.println("성적 : "+ this.score);
	}
}

public class Task01 {
	public static void main(String[] args) {
		Student01 stu1 = new Student01("JJH");
		
		stu1.hello();
	}
}