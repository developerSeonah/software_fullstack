package class05;

import java.util.Scanner;

public class Task02 {

	public static void main(String[] args) {
		//정수를 1개 입력받아주세요
		System.out.println("계절을 판단하는 프로그램입니다.");
				
		Scanner sc = new Scanner(System.in);
		System.out.print("월을 입력해주세요 >>");
		int month = sc.nextInt();

		
		// "월" 범위에 해당하지않는 값
		// 개발자가 "사용자의 입력값"이 올바른지 체크해줘야만 함!!
		// "유효성 검사"
		if(month < 1 || month > 12) {			// 범위상 가장 많기 때문에 가장 먼저
			System.out.println("올바른 입력값이 아닙니다.");
		}
		
		//3,4,5 >> 봄
		//if(정수가 3,4,5 중 하나면) {
		//	봄 출력
		//}
		else if(month == 3 || month == 4 || month == 5) { //입력받은 정수가 3,4,5중 하나면
			System.out.println("봄");
		}
		
		//6 7 8 >>여름
		//else if(정수가 6,7,8면) {
		//	여름 출력
		//}
		else if(month == 6 || month == 7 || month == 8) { //입력받은 정수가 6,7,8중 하나면
			System.out.println("여름");
		}
		
		//9 10 11 >> 가을
		//else if(정수가 9,10,11면) {
		//	가을 출력
		//}
		else if(month == 9 || month == 10 || month == 11) { //입력받은 정수가 9,10,11중 하나면
			System.out.println("가을");
		}
		
		//12 1 2 >> 겨울
		//else {
		//	겨울 출력
		//}
		else {
			System.out.println("겨울");
		}
	}
}