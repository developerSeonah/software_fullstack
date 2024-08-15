package class01;

public class Test02 {

	public static void main(String[] args) {

		for (int a = 0; a < 3; a++) {
			// 3줄을 찍을 것이다
			for (int i = 0; i < 3 - a; i++) {
				// a와 i의 합이 3이상이 되기 전까지 반복
				System.out.print("*");
			}
			System.out.println(); // 줄 넘김
		}
	}
}