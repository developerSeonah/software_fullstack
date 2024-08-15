package class03;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		//정수를 입력합니다.
		//정수 배열, 크기는 5로 생성
		int[] num = new int[5];
		
		//정수 변수 : 대소비교 기준값, 총합값 / 실수 변수 : 평균값
		int pivot, sum = 0;
		double avg = 0;
		
		
		//짝수를 5번 입력하면 종료됩니다.
		//첫 번째값을 배열의 첫 번째와 기준값에 넣은다.
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 5개의 총합, 평균, 최소값을 계산하는 프로그램입니다.");
		while(true) {
			// 짝수 값을 넣을 경우에만 break;
			System.out.print("정수 1 입력 >> ");
			num[0] = sc.nextInt();
			if(num[0]%2 == 0) {	//짝수 값을 넣었을 경우
				break;
			}
			System.out.println("짝수 값만 입력하세요");
		}
		pivot = num[0];

		
		// for문으로 반복, 인덱스 번호[1]부터 반복
		for(int i = 1; i < num.length; i++) {	//1부터 시작해서 인덱스 크기만큼 반복
			//유효성 검사 while문 
			while(true) {
				// 짝수 값을 넣을 경우에만 break;
				System.out.print("정수 "+(i+1)+" 입력 >> ");
				num[i] = sc.nextInt();
				if(num[i]%2 == 0) {	//짝수 값을 넣었을 경우
					break;
				}
				// 짝수외의 값은 다시 입력하라고 출력
				System.out.println("짝수 값만 입력하세요");
			}
		
			//입력받은 값이 기준값보다 작을 경우 기준값에 넣어줌
			if(num[i]<pivot) {		//입력받은 값이 기준값보다 작다면
				pivot = num[i];
			}
		}
		
		//그동안 입력했던 5개의 짝수를 모두출력
		//배열 안의 값을 하나 씩 더함
		System.out.print("배열의 모든 값 : ");
		for(int i = 0; i < num.length; i++) {		//배열의 길이만큼 반복
			System.out.print(num[i]+ " ");
			sum += num[i];
		}
		
		//그 짝수들의 총합과 평균을 출력해주세요.
		//총합 출력
		System.out.println("\n총합 = "+sum);
		
		//평균 출력(총합/배열의 길이)
		//단, 평균은 소수점으로 출력해주세요.
		avg = sum/(double)num.length;
		System.out.println("평균 = "+avg);
		
		//그 짝수들 가운데서 가장 작은 값을 출력해주세요.
		System.out.println("가장 작은 값 : " + pivot);
	}
}