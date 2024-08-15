package class03;

// 함수 3유형
//input x 	output  o

public class Test03 {
	
	public static int test() {
		int a=3, b = 5;
		int sum = a+b;
		return sum;		//함수가 return을 만나면 "즉시" 함수를 종료함
	}

	public static void main(String[] args) {
		
		System.out.println("총합은 "+test()+"입니다.");
		
		// 가독성 때문에 선호도가 더 높음
		int result = test();
		System.out.println("총합은 "+result+"입니다.");
		
	}

}
