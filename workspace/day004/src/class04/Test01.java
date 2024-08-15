package class04;

import java.util.Scanner;

/*
1. test01이라는 함수가 있습니다.
이 함수는 정수를 2개 외부에서 입력받아서,		//input 2개
정수 2개의 평균값을 실수로 반환하는 함수입니다.	//실수 output, 평균값
test01을 작성해주세요.
*/
public class Test01 {
	
	public static double test01(int num1, int num2) {		//4유형
		double avg = (num1 + num2) / 2.0;
		return avg;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두 정수를 받아 평균(실수)로 계산해주는 프로그램");
		System.out.print("첫 번째 정수 >> ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수 >> ");
		int num2 = sc.nextInt();
		
		double avg = test01(num1, num2);
		System.out.println("두 정수의 평균 : "+ avg);
	}
}