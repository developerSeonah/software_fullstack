package class03;

//함수 2유형
//input  o 	output  x

public class Test02 {
	// 정수를 1개 외부에서 받아오면
	// x100을 해서 화면에 출력해주는 함수
	public static void test(int num) {
		num *= 100;
		System.out.println(num);
	}	
	
	/*
	 * 정수 2개를 외부에서 받아와서
	 * 정수들의 평균값을 소수점까지 출력하는 함수를 구현해주세요
	*/
	public static void printAvg(int num1, int num2) {		// 메서드 시그니쳐 부분
		double avg;
		avg = (num1 + num2) / 2.0;
		System.out.println("avg = "+ avg);
	}

	public static void main(String[] args) {
		
//		test(4);
//		test(2);
		
//		int num =2;
//		test(num);		//함수를 호출할 때 인자를 전달하는 방식 : 해당 변수의 "값"만 전달
//						//								== call by value(값에 의한 호출)
//		//main과 test의 num은 서로 다름
//		//test가 끝나는 즉시 test의 메모리는 사라짐
//		
//		System.out.println("num = "+ num);
		
		printAvg(3,2);

	}

}
