package class01;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		
		// 정수를 3개 입력받아서
		// ▶ int 변수 x3
		
		// 총합과 평균을 출력
		// ▶ int 변수, double 변수
		
		// 결론 ▶ int x4, double x1
		int num1, num2, num3;		//사용자에게 입력받을 값 저장공간
		int sum;		//총합
		double avg;		//평균
		
		//세 정수의 입력
		Scanner sc = new Scanner(System.in);
				
		System.out.println("세 정수를 오름차순으로 정렬하는 프로그램입니다.");
		System.out.print("첫 번째 정수 >> ");
		num1 = sc.nextInt();
		System.out.print("두 번째 정수 >> ");
		num2 = sc.nextInt();
		System.out.print("세 번째 정수 >> ");
		num3 = sc.nextInt();
		
		//입력받은 정수들의 총합을 데이터에 저장하는 코드
		sum = num1 + num2 + num3;
		
		// 총합 데이터 /3 해서 평균을 도출하는 코드
		avg = sum / 3.0;  //연산자 총 2개 = 대입 연산자, 산술 연산
		
		System.out.println("총합 = " + sum);
		System.out.println("평균 = " + avg);
		

	}

}
