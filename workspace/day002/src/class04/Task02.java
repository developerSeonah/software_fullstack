package class04;

/*
 2. 1~10까지의 정수를 역순으로 출력해주세요.
ex) 10 9 8 7 ... 1
 */

public class Task02 {

	public static void main(String[] args) {
		// 시작과 끝의 정수
		int start = 1;
		int end = 10;
		
		//범위가 정해져있는 반복문 for
		// 10번 반복
		// 10부터 1씩 역순으로 출력
		for(int i = end; i >= start; i--) {
			System.out.print(i + " ");
		}
	}
}