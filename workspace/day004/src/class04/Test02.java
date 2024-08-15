package class04;

import java.util.Scanner;

/*
test02라는 함수가 있습니다.
함수를 실행하게되면, 사용자로부터 정수를 5번 입력받을수 있게됩니다.	// 정수 5번 받음
그리고 입력한 정수들의 총합을 화면에 출력해줍니다.					//정수, 총합
test02를 작성해주세요.
 */

public class Test02 {
	
	public static void test02() {		//1유형
		Scanner sc = new Scanner(System.in);
		// 정수 5개의 총합을 구할 변수 선언
		int sum = 0;
		
		System.out.println("정수 5개를 입력해주세요.");
		//정수를 5번 입력
		for(int i = 0; i<5; i++) {
			System.out.print("정수"+i+" 입력 >> ");
			sum += sc.nextInt();
		}
		System.out.println("sum = " + sum);
	}

	public static void main(String[] args) {
		
		test02();
	}
}