package class05;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		
		// 정수를 사용자에게 입력받아서
		Scanner sc = new Scanner(System.in);
		
		System.out.println("홀짝을 출력하는 프로그램입니다.");
		//프로그램에 대한 설명
		
		System.out.println("정수를 입력해주세요. >>");
		//사용자에게 친절하게 안내할 의무가 있다!
		int num = sc.nextInt();
		/*
		// 해당 정수가 홀수라면 "홀수입니다."
		// if문이구나
//		if(해당 정수가 홀수라면) {
//			'홀수입니다' 출력하기
//		}
		// '한글 코딩', 스도코딩, 의사코딩
		if(num%2 == 1) {
			System.out.println("홀수입니다.");
		}
		
		// 홀수가 아니라면 == 짝수라면 "짝수입니다."
//		if(홀수가 아니라면) {
//		'짝수입니다' 출력하기
//		}
		if(num%2 != 1) {
			System.out.println("짝수입니다.");
		}*/
		
		//조건문 중에 "양자택일"인 경우,
		if(num%2 == 1) {
			System.out.println("홀수입니다.");
		}
		else {
			System.out.println("짝수입니다.");
		}
		
	}

}
