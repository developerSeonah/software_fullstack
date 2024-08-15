package class01;

import java.util.Scanner;

public class project {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		//Scanner sc = new Scanner(System.in);
		//int a = sc.nextInt();
		
		long endTime = System.currentTimeMillis();
		
		long time = endTime - startTime;
		
		System.out.println(time);
	}
}