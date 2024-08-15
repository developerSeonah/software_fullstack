package class03;

// 함수 1유형
// input  x 	output  x

public class Test01 {

	//함수 선언 자리
	// void == output이 없다.
	// static == 객체와 무관하게
	public static void hello() {
		// 기능 구현
		System.out.println("안녕하세요.");
	}
	
	// 함수라는 것을 개발 할 때 사용하는 이유
	// 1. 코드를 재사용할 수 있음 ★ ====> 유지보수 용이
	//		-> 오류가 없는 코드를 재사용하는 것이기 때문에
	//			오류 검사 비용이 추가x == 경제적
	//			시간이 추가 x == 효율적
	//		=> 오류의 파급효과가 줄어듦
	// 2. main()의 코드 가독성이 좋아짐

	public static void main(String[] args) {
		
		// 함수를 선언 하는 행위		: 함수 정의
		//	!= 함수를 사용하는 행위	: 함수 호출
		hello();

	}

}
