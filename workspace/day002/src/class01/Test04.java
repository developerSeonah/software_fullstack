package class01;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		
		// 정수 2개를 입력받고
		// 연산자 1개를 입력받음
		Scanner sc = new Scanner(System.in);
		int num1, num2;  // 사용자에게 입력받을 정수
		String op;		// 연산자
		// 문자열은 일반변수(원시타입변수)가 아니며,
		// 연산자는 일반변수만 계산할 수 있다.
		// 연산자로는 객체를 계산할 수가 없음
		int res = 0;		//결과
		
		System.out.println("정수 2개와 연산자를 입력하면 결과를 출력하는 프로그램");
		System.out.print("정수 1 입력 >> ");
		num1 = sc.nextInt();
		System.out.print("정수 2 입력 >> ");
		num2 = sc.nextInt();
		//next()  공백을 제외한 모든 String을 받아들이는 함수. 공백 뒤의 모든 값은 없애버림, 띄어쓰기 입력x
		
		sc.nextLine();		//버퍼 공간 지우기
		
		System.out.print("연산자 입력(+, -) >> ");
		op = sc.nextLine(); //버퍼에 이미 전달한 값이 남아있어서 사용자가 입력했구나
		System.out.println("op = ["+op+"]");
		
		
		
		// 정수 + 연산자 + 정수
		// 연산자가 + 였다면
		// 정수 + 정수
		if(!(op.equals("+") || op.equals("-"))) {  // op가 +, -가 아닌 연산자가 입력됐다면
			res = 0;
		}
		
		else if(op.equals("+")) {
			res = num1 + num2;
		}
		// 연산자가 - 였다면
		// 정수 - 정수
		else if(op.equals("-")) {
			res = num1 - num2;
		}
	
		// 전체 계산 결과를 출력
		System.out.println(num1 + " " + op + " " + num2 + " = " + res);		
		
	}
}