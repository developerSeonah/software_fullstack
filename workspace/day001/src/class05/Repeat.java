package class05;

import java.util.Scanner;

/*
1. 정수를 3개 입력받아주세요.
ex) a= 10, b=8, c=5
	a =5, b = 8, c = 10
a,b,c가 오름차순이 되도록 데이터를 변경해주세요.
 */
// 과제한 것이랑 다른 풀이로 가장 큰 것부터 했을 때는 모든 if, else if에 이중으로 if가 들어감

public class Repeat {

	public static void main(String[] args) {
		// 입력받을 세 정수와 교체할 때 보관할 박스
		int a, b, c, box;
		
		//세 정수의 입력
		Scanner sc = new Scanner(System.in);
		
		System.out.println("세 정수를 오름차순으로 정렬하는 프로그램입니다.");
		System.out.print("첫 번째 정수 a >> ");
		a = sc.nextInt();
		System.out.print("두 번째 정수 b >> ");
		b = sc.nextInt();
		System.out.print("세 번째 정수 c >> ");
		c = sc.nextInt();
		
		//1차 정렬, c부터 정렬
		if(a > b && a > c){//세 정수중 a가 가장 크다면
			//a를 c와 교환
			box = a;
			a = c;
			c = box;
		}
		
		else if(a < b && b > c){//세 정수중 b가 제일 크다면
			//b와 c를 교환
			box = b;
			b = c;
			c = box;
		}
		
		//c가 가장 크다면 바뀌는게 없으니 생략
		
		//2차 정렬, a와 b 비교
		if(a > b){//만약 a가 b보다 크다면
			//b와 a교환
			box = a;
			a = b;
			b = box;
		}
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
	}
}