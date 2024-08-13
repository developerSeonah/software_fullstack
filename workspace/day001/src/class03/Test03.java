package class03;

import java.util.Scanner;
// Scanner은 java.util 안에 있다.
// ctrl + shift + o
// 자동으로 import 지원 => 개발도구 사용이유

public class Test03 {

	public static void main(String[] args) {
		
		// 사용자에게 입력을 받아오기
		// Scanner 라는 것이 필요함
		
		Scanner sc = new Scanner(System.in);
		// Scanner은 일반변수x, 객체o
		// 대문자로 시작? -> 클래스 출신
		// 어디에 있는 걸 스캔받을 지 알려줘야한다. (System.in)
		// 객체는 함수와 함께 생성됨
		
		System.out.print("정수 입력. >>");
		int data = sc.nextInt();
		
		System.out.println("프로그램 종료됨");
		System.out.println("data = " + data);

	}

}
