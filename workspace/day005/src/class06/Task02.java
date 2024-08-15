package class06;

import java.util.Random;

//학생 클래스
class Student02{
	// 멤버변수 : 이름, 성적(정수), 등급(char)
	String name;
	int score;
	char grade;

	// 생성자 : 이름 '강제'
	Student02(String name) {
		this.name = name;

		// 성적 랜덤(0~100)
		Random rand = new Random();
		this.score = rand.nextInt(101);
		
		setGrade();
	}

	// hello()하면 이름과 성적, 등급을 화면에 출력
	void hello() {
		System.out.println("이름 : " + this.name);
		System.out.println("성적 : " + this.score);
		System.out.println("등급 : " + this.grade);
	}

	// test() 시험을 보면, 성적이 현재성적점수 +10점
	void test() {
		this.score += 10;
		// 100점 초과는 없으므로
		if(this.score > 100) {
			this.score = 100;
		}
		
		setGrade();
	}
	
	void setGrade() {
		if (this.score < 60) {
			this.grade = 'C';
		} 
		else if (this.score < 80) {
			this.grade = 'B';
		} 
		else {
			this.grade = 'A';
		}
	}
}

public class Task02 {
	public static void main(String[] args) {
		
		Student02 stu1 = new Student02("JJH");
		
		stu1.hello();
		System.out.println("--------------");
		stu1.test();
		stu1.hello();
	}
}