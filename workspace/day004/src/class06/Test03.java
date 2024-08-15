package class06;

import java.util.Random;
import java.util.Scanner;

//함수를 사용해서 프로그램 제작하기

//랜덤으로 정수를 하나 생성해서
//사용자가 해당 정수를 맞추는 프로그램입니다.
// 정답을 맞추면 ㅊㅋ
// 못맞추면 재시도 -> 맞출 때까지

public class Test03 {
	
	public static int makeRandNum() {
		Random rand = new Random();
		return rand.nextInt(10)+1;
	}
	
	public static void printInfo() {
		System.out.println("정답이 아닙니다.");
		System.out.println("다시 시도해 보세요.");
	}
	
	public static void hello() {
		System.out.println("축하합니다☆");
	}
	
	public static boolean isRight(int ans) {
		//정답을 맞추는 과정
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정답을 입력하세요. >> ");
		int num = sc.nextInt();
		
		if(num == ans) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		
		//랜덤으로 정수 생성하기
		int ans = makeRandNum();
		// makeRandNum()		//메서드 시그니쳐 유추하기
		// input x   output  o	
		
		while (true) {
	
			if(isRight(ans)) {	//맞추면
				break;
			}
			// 못맞췄다고 말해주기
			printInfo();
			// input x  output x;
			
		}
		//축하해주기
		hello();

	}

}
