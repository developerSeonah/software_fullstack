package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test02 {
	public static Scanner sc = new Scanner(System.in);

	public static int makeNum(int[] datas) {
		// 0 ~ 4 까지만 입력 가능
		// 만약 이외의 정수를 입력했다면, 무조건 [0]에 존재하는 10을 선택
		// 제대로 입력할 때까지 반복
		int num;
		while(true) {
			System.out.print("정수1 입력 >> ");
			try {
				num = sc.nextInt();
			}
			catch (InputMismatchException e) {
				sc.nextLine();	// 버퍼 청소
				System.out.println("다시 입력해주세요.");
				continue;
			}
			// catch문에 안 닿으면
			break;
		}
		try {	
			num = datas[num];
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("없는 인덱스를 입력해서 [0]값으로 변경하였습니다.");
			num = datas[0];
		}

		return num;
	}

	public static void main(String[] args) {
		// 인덱스 번호를 입력하면 해당 인덱스의 값을 나누는 프로그램

		int[] datas = {10, 0, -1, 2, 3};

		int num1 = makeNum(datas);
		int num2 = makeNum(datas);

		try {
			int result = num1 / num2;
			System.out.println(num1 + " / "+ num2 +" = " + result);
		}
		catch(ArithmeticException e) {
			System.out.println("0으로는 나누기를 할 수 없습니다.");
		}
	}
}

