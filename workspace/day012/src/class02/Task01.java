package class02;

import java.util.ArrayList;
import java.util.Scanner;

/*
1~100 사이의 정수를 사용자가 입력합니다.
짝수라면 배열리스트에 추가해주시고,
짝수가 아니라면 x2하여 배열리스트에 추가해주세요.
배열리스트의 요소개수가 3개가 되면 더 이상 입력받지 않고,
그동안 저장했던 요소들을 출력해주시고
총합을 출력해주세요!
 */
public class Task01 {
	public static void main(String[] args) {
		// 변수, 객체 선언
		// 합을 담을 정수형 sum 변수
		int sum = 0;
		// 배열 리스트 객체
		ArrayList<Integer> al = new ArrayList<Integer>();
		// Scanner 객체
		Scanner sc = new Scanner(System.in);	

		// 값을 받는 부분
		while(true) {
			// 입력값을 담을 변수
			int num;

			// 1~100 사이의 정수를 사용자가 입력
			System.out.print("1~100사이의 정수를 입력해주세요 >>");
			num = sc.nextInt();

			// 유효성 검사
			// 만약 값이 1~100 사이 값이 아니라면 값을 다시 받음
			if(num <= 1 && 100 <= num) {
				// 아니면 다시 입력해주세요 출력
				System.out.println("다시 입력해주세요.");
				continue;
			}

			// 넘기지 않았으면 값을 담게 됨
			// 양자일택, 삼항 연산자
			al.add(num%2 == 0 ? num : num*2);


			// 만약 배열리스트의 요소 개수가 3개가 되면
			if(al.size() >= 3) {
				break;
			}
		}

		// 총합을 구하는 부분
		// for each문
		for(int num : al) {
			// 배열리스트를 차례로 불러와서 sum 변수에 집어넣음
			sum += num;
		}

		// 요소들 출력
		System.out.println(al);
		// 총합을 출력
		System.out.println("총합 : "+ sum);
	}
}
