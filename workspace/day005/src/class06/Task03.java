package class06;

import java.util.Random;

//학생 클래스
class Student03{
	// 멤버변수 : 학번(PK,정수), 이름, 성적(정수), 등급(char)
	int number;	// PK : 사용자가 지정 (x), / 시스템에 값을 부여 (o)
								// ID, 핸드폰 번호, 이메일 => PK (x)
	String name;
	int score;
	char grade;

	// 생성자 : 이름 '강제'
	Student03(int number, String name) {
		this.name = name;

		// 성적 랜덤(0~100)
		Random rand = new Random();
		this.score = rand.nextInt(101);
		
		//학생의 번호는 1001번부터 차례대로 증가하며 부여
		// PK에서 외부(시스템)에서 값ㅇ르 부여받아야 한다
		this.number = number;

		// 등급 C(성적 0~59), B(60~79) A(성적 80~100)
		setGrade();
	}

	// hello()하면 이름과 성적, 등급을 화면에 출력
	void hello() {
		System.out.println("학번 : " + this.number);
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
public class Task03 {
	public static void main(String[] args) {
		
		int NUM = 1001;
		
		Student03 stu1 = new Student03(NUM++, "JJH");
		stu1.hello();
		
		System.out.println("--------------");
		Student03 stu2 = new Student03(NUM++, "JOH");
		stu2.hello();
		
		System.out.println("--------------");
		Student03 stu3 = new Student03(NUM++, "JJJ");
		stu3.hello();
	}
}