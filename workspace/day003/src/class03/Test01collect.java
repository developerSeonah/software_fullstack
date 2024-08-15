package class03;

import java.util.Scanner;

public class Test01collect {

	public static void main(String[] args) {
		//성능보다 가독성을 위해 따로따로 프로그램을 짬
		//성능차이는 크지 않음
		
		//정수를 입력합니다.
		//짝수를 5번 입력하면 종료됩니다.
		//여러번 입력하는 구나!
		
		Scanner sc=new Scanner(System.in);
	      
	      int[] datas=new int[5];
	      
	      int cnt=0; // 짝수가 몇번 입력되었는지 확인하는 변수
	      while(true) {
	         System.out.print("정수 입력 >> ");
	         int num=sc.nextInt();
	         
	         if(num%2==0) {
	            datas[cnt]=num;            
	            cnt++;
	         }
	         
	         if(cnt==datas.length) {
	            break;
	         }         
	      }
	      
	      
	      // 그동안 입력했던 5개의 짝수를 모두출력해주세요.
	      System.out.print("[ ");
	      for(int i=0;i<datas.length;i++) {
	         System.out.print(datas[i]+" ");
	      }
	      System.out.println("]");


		// 그 짝수들의 총합과
		int sum = 0;
		for(int i = 0;i<datas.length;i++) {
			sum += datas[i];
		}
		System.out.println("총합 : "+ sum);
		
		//평균을 출력해주세요
		double avg = sum*1.0/datas.length;
		System.out.println("평균 : "+ avg);
		
		//그 짝수들 가운데서 가장 작은 값을 출력해주세요.
		int pivot = datas[0];	//기준
		for (int i = 0; i < datas.length; i++) {
			if(pivot>datas[i]) {
				pivot = datas[i];
			}
		}
		System.out.println("최소값은 "+pivot+"입니다.");
	}

}
