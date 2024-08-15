package class02;

public class Test02 {

	public static void main(String[] args) {

//		int stu1 = 10;
//		int stu2 = 90;
//		int stu3 = 87;
//		// 메모리를 서로 옆에 둘 필요성을 못 느낌
//
//		for (int i = 1; i <= 3; i++) {
//			System.out.println("학생 "+i+"번의 점수는 " + stu1 + "점 입니다.");
//		}
//		// 이런상황 때문에 배열이 필요

		// 관련성 있고, 자료형도 같은 메모리 공간을 3개 만듬
		int[] student = new int[3];
		// 각 메모리 공간을 [index]를 붙여서 관리
		student[0] = 10;
		student[1] = 90;
		student[2] = 87;

		for (int i = 0; i < 3; i++) {
			System.out.println("학생 "+i+"번의 점수는 "+ student[i]+"점 입니다.");
		}
	}
}