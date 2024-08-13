package class04;

import java.util.Scanner;

/*
 정수는 5번 입력합니다. 모든 입력이 끝난후, 입력한 정수중에서 가장 큰 값을 출력해주세요.
 */

public class Task04 {

	public static void main(String[] args) {
		
		// 입력받을 정수 5개(배열), 가장 큰 정수 1개
		int num;	//입력받을 정수 5개
		int pivot;				//최대값

		Scanner sc = new Scanner(System.in);
		
		System.out.println("5개의 입력받은 정수 중 가장 큰 값알 출력하는 프로그램입니다.");
		
		//5개의 정수를 입력받는다.
		System.out.print("정수를 입력하세요 >> ");
		pivot = sc.nextInt();
		
		for(int i = 1; i <= 4; i++) {
			System.out.print("정수를 입력하세요 >> ");
			num = sc.nextInt();
			
			if(pivot < num) {
				pivot = num;
			}
		}
		
		// 가장 큰 값 출력
		System.out.println("가장 큰 값 : " + pivot);
	}
}