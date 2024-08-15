package class03;

//함수 3유형
//input o 	output  o

public class Test04 {
	
	//외부에서 정수 2개를 받아와서
	//정수 2개의 합을 반환하는 함수
	 public static int plus(int a, int b) {
		System.out.println("plus() 함수 호출 됨");
		//로그 역할
		
		return a+b;
	}
	
	//외부에서 정수를 1개 받아와서
	//해당 정수가 짝수인지 홀수인지 반환하는 함수
	 public static boolean isEven(int num) {		//isXxxx(), hasXxxx() ------> boolean 반환
		 if(num%2 == 0) {
			 return true;
		 }
		 return false;
		 
		 //return num%2 == 0 ? true : false;
		
	}
	

	public static void main(String[] args) {
		
//		int result = plus(10,20);
//		System.out.println(result);
		
		if(isEven(20)) {
			System.out.println("짝수");
		}
		else {
			System.out.println("홀수");
		}
	}

}
