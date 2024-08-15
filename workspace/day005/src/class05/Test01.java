package class05;

import java.util.Scanner;

// JAVA로 객체지향 코딩
// 기본단위 == class

// 학생에 대한 정의를 하기 위해 존재하는 class
// 이 객체의 값을 "식별" 할 수 있는 데이터가 있니?
//	== PK
class Student{
	int num;	// 학번. PK 역할!
	String name;
	int score;
	char grade;
	Student(){		//별도로 쓰지 않아도 기본 제공
		System.out.println("숨겨져 있던 생성자");
	}
}
// Student 라는 자료형이 있습니다.
// [학번, 이름, 점수, 등급]을 저장할 수 있습니다.

// main()을 수행하기 위해 존재하는 class
public class Test01 {
	public static void main(String[] args) {
		
		Student stu1 = new Student();
		// 객체지향 언어 JAVA는
		// 기본 생성자 함수를
		// 기본으로 제공해줍니다.
		
		int num; //초기화 x == 값 저장 x
		int[] datas = new int[5];
		
		// 힙(개발자) 메모리를 사용했기 때문!
		// 기본적으로
		// int 0 double 0.0 String null ...
		// 초기화를 보장해준다.
		
//		System.out.println(num);	//초기확 되지 않아 출력이 안 됨
		System.out.println(datas[0]);
	}

}
