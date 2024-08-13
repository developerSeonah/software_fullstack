package class04;

import java.util.Scanner;

/*
 1~100사이의 정수만 1번 입력합니다. 입력한 정수의 약수들을 모두 출력해주세요.
 */

public class Task05 {

	public static void main(String[] args) {
		// 입력받을 정수 1개
		int num;
		
		// 정수를 입력받는다.
		Scanner sc = new Scanner(System.in);
		
		System.out.println("입력받은 정수의 모든 약수를 출력합니다.");
		
		// 유효성 검사
		while(true) {
			System.out.print("정수 입력 >> ");
			num = sc.nextInt();
			if(1<=num && num <= 100) {
				break;
			}
		}
		
		// break가 종료조건없이 작성된 경우, 그 기능은 태생이 반복을 안하는 코드다
		
		//입력받은 정수만큼 반복
		for(int i = 1; i <= num; i++) {			// 1부터 num까지의 수만큼 반복
			if(num%i == 0) {					// 입력받은 '정수 % i'가 0이라면
				System.out.print(i + " ");		//i를 출력
			}
		}
	}
}