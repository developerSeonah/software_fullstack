package class04;

import java.util.Scanner;

/*
 1. 정수를 입력받습니다.
입력된 정수가 짝수라면 총합에 더해주세요.
0이하가 입력되면 멈춥니다.
멈추고서 최종 총합을 출력해주세요
 */

public class Task01 {

	public static void main(String[] args) {
		//입력받을 정수 1개, 총합 정수 1개
		int num;		//입력받을 정수
		int sum = 0;  	//합이 들어갈 것이므로 0으로 초기화
	
		Scanner sc = new Scanner(System.in);
		System.out.println("입력된 정수의 짝수들의 합을 구하는 프로그램입니다.");
		System.out.println("(0이 되면 멈춤)");
		
		while(true){			//횟수가 없으므로 무한반복
			
			// 정수를 입력받는다.
			System.out.print("정수를 입력해주세요. >>");
			num = sc.nextInt();
			
			// 종료조건문
			if(num <= 0) { // 만약 입력된 정수가 0이하라면
				break;// 반복을 멈춘다.
			}
			
			if(num%2 == 0){// 만약 입력된 정수가 짝수라면, 위의 조건과는 상관없기 때문에 따로 if문
				sum += num;// 총합에 더한다
			}
		}
		
		//최종합을 출력한다.
		System.out.println("총합 : " + sum);
	}
}