package class05;

import java.util.Scanner;

/*
 2. 정수를 3개 입력 받아주세요.
총합 =xxx
평균 = xx.xxxxx
 */

public class Task04 {

	public static void main(String[] args) {
		//총합과 평균을 담을 변수
		int sum;
		double avg;
		
		//정수 3개를 입력
		Scanner sc = new Scanner(System.in);
				
		System.out.println("세 정수의 총합과 평균을 구하는 프로그램입니다.");
		System.out.print("첫 번째 정수 입력 >>");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수 입력 >>");
		int num2 = sc.nextInt();
		System.out.print("세 번째 정수 입력 >>");
		int num3 = sc.nextInt();
		
		//총합
		//세 정수의 합 num1 + num2 + num3
		sum = num1 + num2 + num3;
		
		//평균
		//세 정수의 합 / 3 => num1 + num2 + num3 / 3  == sum / 3
		avg = sum / 3.0;
		
		//총합과 평균의 
		System.out.println(sum);
		System.out.println(avg);
	}
}