package class05;

import java.util.Scanner;

/*
 3. 정수 2개를 입력받아주세요.
연산자 1개를 입력받아주세요.(연산자는 +, -만)
정체 계산 결과를 출력해주세요.
10 20 +
10 + 20 = 30
 */

public class Task05 {

	public static void main(String[] args) {
		
		//정수 2개, 연산자 입력
		Scanner sc = new Scanner(System.in);
						
		System.out.println("두 정수를 +, - 둘 중 하나로 계산하는 프로그램입니다.");
		System.out.print("첫 번째 정수 입력 >>");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수 입력 >>");
		int num2 = sc.nextInt();
		System.out.print("연산자 입력 >>");
		String ope = sc.next();
		
		//만약 연산자가 +, - 외의 것이라면
		if(!ope.equals("+") && !ope.equals("-")) {
			// 잘못된 연산자입니다.
			System.out.println("잘못된 연산자입니다.");
		}
		
		//만약 연산자가 +라면
		else if(ope.equals("+")) {
			//첫 번째 정수 + 두 번째 정수 출력
			System.out.println(num1 + num2);
		}
		
		//만약 연산자가 -라면
		else {
			//첫 번째 정수 - 두 번째 정수
			System.out.println(num1 - num2);
		}
	}
}