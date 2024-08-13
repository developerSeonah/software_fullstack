package class04;

import java.util.Scanner;

/*
 3. 정수를 2개 입력받아서 오름차순으로 출력해주세요.
ex) a=3, b=5	3 4 5
ex) a=10 b=8	8 9 10
 */

public class Task03 {
	public static void main(String[] args) {
		// 입력받을 정수 2개 선언, 오름차순의 시작과 끝부분 값 정수 선언 2개
		int num1, num2;		//입력받을 정수
		int start, end;		//오름차순의 시작과 끝
		
		// 정수 2개 입력
		Scanner sc = new Scanner(System.in);
		System.out.println("입력받은 정수 2개의 범위를 오름차순으로 정렬하는 프로그램입니다.");
		System.out.print("정수1 입력 >> ");
		num1 = sc.nextInt();
		System.out.print("정수2 입력 >> ");
		num2 = sc.nextInt();
		
		// 두 정수의 크기 비교
		start = num1 < num2 ? num1 : num2;
		end = num1 > num2 ? num1 : num2;
		
		// 작은 수부터 큰 수까지의 범위에서 반복
		// 작은 수에서 1씩 증가하여 반복
		for(int i = start; i <= end; i++) {		//i값이 start값부터 end값까지 1씩 증가하여 반복
			System.out.print(i + " ");			// i 출력, 입력받은 정수의 오름차순 출력
		}
	}
}