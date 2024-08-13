package class03;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("문자열을 입력 >>");
		String str = sc.nextLine();
		
		System.out.println("정수 입력 >>");
		int i = sc.nextInt();
		
		System.out.println("실수 입력 >>");
		double d = sc.nextDouble();
		
		System.out.println("str = " + str);
		System.out.println("i = " + i);
		System.out.println("d = " + d);

	}
}