package view;

import java.util.Scanner;

abstract class View {
	public static Scanner sc = new Scanner(System.in);

}

public class MainView extends View{
	// 글 전체 출력
	// 글 검색 : 제목
	// 글 검색 : 작성자
	// 글 1개 선택
	// 종료
	
	// 메뉴 출력
	public void printMenu() {
		System.out.println("0. 종료");
		System.out.println("1. 글 전체 출력");
		System.out.println("2. 글 검색 : 제목");
		System.out.println("3. 글 검색 : 작성자");
		System.out.println("4. 글 1개 선택");
	}
	// 메뉴 입력
	public int inputMenuNum(){
		System.out.print("메뉴 입력 >> ");
		int num = sc.nextInt();
		return num;
	}
	
	// 성공, 실패 출력
	public void printTrue() {
		System.out.println("성공!");
	}
	public void printFalse() {
		System.out.println("실패...");
	}
	
	// 종료 출력
	public void printExit() {
		System.out.println("프로그램 종료");
	}
}
