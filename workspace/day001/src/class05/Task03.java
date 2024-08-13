package class05;

import java.util.Scanner;

/*
1. 정수를 3개 입력받아주세요.
ex) a= 10, b=8, c=5
	a =5, b = 8, c = 10
a,b,c가 오름차순이 되도록 데이터를 변경해주세요.
 */

public class Task03 {
	public static void main(String[] args) {
		//입력받을 3개의 변수(a,b,c)와 교체할 때 사용할 변수 1개
		int a, b, c, box = 0;
		
		//정수 3개를 입력
		Scanner sc = new Scanner(System.in);
		
		System.out.println("세 정수 a, b, c가 오름차순이 되도록 데이터를 변경하는 프로그램입니다.");
		System.out.print("첫 번째 정수(a) 입력 >>");
		a = sc.nextInt();
		System.out.print("두 번째 정수(b) 입력 >>");
		b = sc.nextInt();
		System.out.print("세 번째 정수(c) 입력 >>");
		c = sc.nextInt();
		
		
		//가장 먼저 a에 작은 수를 넣기(1차 정렬)
		//만약 a가 c보다 크다면 a와 c와 교환
		if(a > c) {				//a가 c보다 크다면
			//a와 c의 교환
			box = a;
			a = c;
			c = box;
			
			//크기 순서가 3 1 2 인 경우
			if(a > b) {		//a가 b보다 크다면
				//a와 b의 교환
				box = a;
				a = b;
				b = box;
			}
		}
		
		//만약 a가 b보다 크다면 a와 b와 교환
		else if(a > b) {		//a가 b보다 크다면
			//a와 b의 교환
			box = a;
			a = b;
			b = box;
		}
		
		
		//b와 c 정리(2차 정렬)
		if(b > c) {		//b가 c보다 크다면
			//b와 c의 교환
			box = b;
			b = c;
			c = box;
		}
		
		//오름차순으로 정렬된 정수 a,b,c 출력
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("c : " + c);
	}
}