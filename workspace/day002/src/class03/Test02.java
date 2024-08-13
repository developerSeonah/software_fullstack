package class03;

import java.util.Scanner;

// 자판기 프로젝트 01

public class Test02 {

	public static void main(String[] args) {
		
		// 사용자에게 금액을 입력받고
		// 판매 가능한 상품을 보여줄 예정
		// 사용자가 원하는 메뉴를 입력
		// 해당 상품을 주고
		//   >> 해당 상품보다 돈이 적은 경우 줄 수 없음
		// 돈이 남아있으면 반환
		
		Scanner sc = new Scanner(System.in);
		int money;		// 사용자에게 받을 금액
		int menu;		// 사용자에게 입력받을 메뉴
		
		int product1 = 1200; //콜라
		int product2 = 900; //사이다
		
		// 상품 출력
				System.out.println("---------------");
				System.out.println("1. 콜라 1200원");
				System.out.println("2. 사이다 900원");	
				System.out.println("---------------");
		
		// 사용자에게 금액 입력받아서
		// 사용자의 입력? >> 유효성 검사
		// 사용자가 0 초과 10000 미만의 입력을 통과
		// 그 전까지는 계속 재입력
		while(true) {
			System.out.print("자판기에 넣을 금액 입력 >>");
			money = sc.nextInt();
			if(0 < money && money < 10000) {		//제대로 입력했다면
				break;
			}
			System.out.println("0~10000 사이로 입력해주세요!");
		}
		
		// 사용에게 메뉴 입력 받아서
		// 1~2만 입력 가능
		// 잘못입력하면 다시 입력
		while (true) {
			System.out.print("메뉴를 입력 >> ");
			menu = sc.nextInt();
			if(menu == 1 || menu == 2) {
				break;
			}
			System.out.println("1~2 사이에서 골라주세요.");
		}
		
		// 상품 주기
		// ※ 유효성 검사를 했기 때문에, 콜라 사이다만 구현하면 됨!
//		if(콜라라면) {
//			if(금액이 부족하면) {
//				지급x
//			}
//			넣은 돈 - 콜라금액
//		}
//		else if(사이다라면) {
//			if(금액이 부족하면) {
//				지급x
//			}
//			넣은돈 - 사이다금액
//		}
		
		if(menu == 1) {
			if(money < product1) {
				System.out.println("금액이 부족합니다...");
			}
			else {
				money -= product1;
				System.out.println("콜라 나왔습니다.");
			}
		}
		else if(menu == 1) {
			if(money < product2) {
				System.out.println("금액이 부족합니다...");
			}
			else {
				money -= product2;
				System.out.println("사이다 나왔습니다.");
			}
		}
		
		// 남은 돈이 있다면 반환
		if(money > 0) {
			System.out.println("남은돈 " +money+ "원이 반환됩니다.");
		}	
	}
}