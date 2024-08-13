package class05;

import java.util.Scanner;

public class Task01 {

	public static void main(String[] args) {
		//정수를 1개 입력받아주세요
		System.out.println("10의 약수인지 확인하는 프로그램입니다.");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 1개 입력해주세요 >>");
		int num = sc.nextInt();
		
		//추가
		// * 프로그램은 if문 1개당 1개의 기능으로 판단 
		// * 1개의 if문 당 1개의 기능만을 수행해야함
		if(num == 0) {
			System.out.println("0으로 나누기를 할 수 없습니다.");
			return; //긴급종료
		}
		
		
		// 입력된 정수가 10의 약수라면 ㅇㅋ
		//if(정수가 10의 약수라면) {
		//	ㅇㅋ 출력
		//}
		if(10%num == 0) {						//정수가 1이면
			System.out.println("ㅇㅋ");
		}

		// 아니라면 x 출력해주세요
		//else {
		//	x출력
		//}
		else {
			System.out.println("x");
		}
		
		//☆ 가독성이 중요!!
		// 1. 블록 구간
		// 2. {} 생략x
	}
}