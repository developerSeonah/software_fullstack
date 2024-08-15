package class01;

public class Test01 {

	public static void main(String[] args) {
		
		// 2x1=2, 2x2=4, ... , 2x9=18
		// 반복되는 문장이 있을 때,
		// 달라지는 부분을 변수로 둔다.
		
		//ctrl + c, v ---> 반복문
//		for(int i = 1; i <= 9; i++) {
//			System.out.println("2 x "+i+" = " + (2*i));
//		}
//		for(int i = 1; i <= 9; i++) {
//			System.out.println("3 x "+i+" = " + (3*i));
//		}
//		for(int i = 1; i <= 9; i++) {
//			System.out.println("4 x "+i+" = " + (4*i));
//		}
		
		for(int a = 2; a <= 9; a++) {
			for(int i = 1; i <= 9; i++) {
				System.out.println(a+" x "+i+" = " + (a*i));
			}
			System.out.println("--------------------------");
		}
		
		// 내가 원하는 코드, 어디에 넣어야 할까?
		// 웹 코딩가면 콘솔이 없어서 못 찍음
		// 1. 뉘양스 파악
		// 2. 반복문 깊이 파악
		
		
		
		
		
		

	}

}
