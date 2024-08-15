package class04;

import java.util.Random;

/*
test03이라는 함수가 있습니다.
함수를 실행하게되면, 1~100사이의 정수중 랜덤으로 1개의 값을 생성합니다.
그리고 생성한 정수값을 반환합니다.
test03을 작성해주세요.
 */

public class Test03 {
	
	public static int test03() {		// 3유형
		Random random = new Random();
		//1부터 100까지
		//random.nextInt(100) => 0부터 99까지
		int num = random.nextInt(100)+1;
		
		return num;
	}

	public static void main(String[] args) {
		
		int num = test03();
		
		System.out.println("랜덤 값 : "+num);

	}

}
