package class03;

import java.awt.font.NumericShaper;
import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		// 배열의 크기를 정할 정수 변수
		int num;

		// 정수를 입력합니다.
		// 입력한 만큼 정수를 저장할수있게됩니다.(배열의 크기를 사용자가 지정)
		Scanner sc = new Scanner(System.in);
		// 배열의 크기는 0이상이여야 한다.
		while (true) {
			System.out.print("배열의 크기를 정할 정수를 입력해주세요 >> ");
			num = sc.nextInt();
			if (num > 0) { // 정수가 0이상이라면
				break;
			}
			System.out.println("배열의 크기는 0이상이여야 합니다.");
		}

		// 입력된 값 크기의 배열 생성
		int[] number = new int[num];

		// 배열에 정수를 입력받아 저장
		for (int i = 0; i < number.length; i++) { // 0부터 배열의 크기만큼 반복
			System.out.print("배열의 " + (i + 1) + "번째 인덱스에 들어갈 정수를 넣어주세요 >> ");
			number[i] = sc.nextInt();
		}

		// 1개의 정수를 입력받는다.
		// 입력받는 정수는 인덱스 크기에 안에서만 가능하도록 한다.
		System.out.println("배열의 알고싶은 인덱스 값을 넣어주세요. (1~" + number.length + ")");

		int n;
		while (true) {
			System.out.print(">> ");
			n = sc.nextInt();
			if (0 <= (n-1) && (n-1) < number.length) { // 0부터 배열크기-1 사이값이라면
				break;
			}
			System.out.println("1부터 " + number.length + "사이의 수를 넣어주세요");
		}

		// 배열의 입력받은 정수에 해당하는 인덱스의 값을 출력한다.
		System.out.println(n + "번째 공간에는 " + number[n-1] + "이 저장되어있습니다.");
	}
}