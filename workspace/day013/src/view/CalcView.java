package view;

import java.util.Scanner;

public class CalcView {
	static Scanner sc = new Scanner(System.in);
	

	// 정수 1개 입력하세요.
	// >> 10
	public void printIntInfo() {
		System.out.println("정수 1개를 입력하세요.");
		System.out.println(">> ");
	}
	public int inputInt() {
		int num = sc.nextInt();
		return num;	// 사용자가 입력한 값을 전달해야하니까 반환을 해야 함.
	}

	// 연산자를 입력하세요.
	// 단, 연산자는 +, -, x 만 지원됩니다.
	// >> +
	public void printOpInfo() {
		System.out.println("연산자를 입력하세요.");
		System.out.println("단, 연산자는 +, -, x 만 지원됩니다.");
		System.out.println(">> ");
	}
	public String inputOp() {
		String op;
		while(true) {
			op = sc.next();
			if(op.equals("+") ||op.equals("-")||op.equals("x{")) {
				break;
			}
			System.out.println("다시 입력해주세요!");
			System.out.println(">> ");
		}
		return op;
	}

	// 10 + 2 = 12 입니다.
	public void printResult(int num1, String op, int num2, int result) {
		System.out.println(num1 +" " + op +" "+ num2 + " = " + result);
		// 보여주는 애지 계산을 하는 애가 아님
	}
}
