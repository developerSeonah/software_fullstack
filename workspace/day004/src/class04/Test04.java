package class04;
/*
test04라는 함수가 있습니다.
이 함수는 외부로부터 정수를 1개 받아와서
해당 정수의 약수들을 화면에 출력해줍니다.
test04를 작성해주세요.
 */
public class Test04 {
	
	public static void test04(int num) {		//2유형
		//num의 약수이므로 최대 num까지 반복
		for(int i = 1; i <= num; i++) {
			// 만약 num%i가 0이라면
			if(num%i == 0) {
				// i는 약수 값이다.
				System.out.print(i + " ");
			}
		}
	}

	public static void main(String[] args) {
		test04(12);
	}
}