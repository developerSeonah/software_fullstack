package class05;

import java.util.Scanner;

//N지선다
public class Test02 {
	public static void main(String[] args) {
		// 정수 2개를 입력받아주세요.
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 2개의 크기를 출력하는 프로그램입니다.");
		System.out.print("정수 1 입력 >> ");
		int num1 = sc.nextInt();
		System.out.print("정수 2 입력 >> ");
		int num2 = sc.nextInt();
		
		//a가 더 큰지, b가 더 큰지, a와 b가 같은지 출력해주세요.
		if(num1> num2) {		//num1이 num2보다 크다면
			// if else if문은 확률이 높은 경우를 상단에 배치한다.
			System.out.println(num1);
		}
		else if(num1 < num2) {		//num2가 num1보다 크다면
			System.out.println(num2);
		}
		else {
			System.out.println("둘의 크기는 같습니다.");
		}
		
		//확률적으로 더 많이 발생하는 것이 맨 위로 와야 효율적
		
	}
}
