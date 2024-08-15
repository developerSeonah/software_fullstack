package class03;

import java.util.Scanner;

public class Testo2collect {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

	      // 정수를 입력합니다.
	      // 입력한 만큼 정수를 저장할수있게됩니다.
	      //  : (사용자가 입력한 정수)개

	      int num; // 사용자가 입력한 정수
	      while(true) {
	         System.out.print("정수 입력 >> ");
	         num=sc.nextInt();
	         if(0<num) {
	            break;
	         }
	         System.out.println("0보다 큰 정수를 입력해주세요!");
	      }
	      int[] datas=new int[num];


	      // 정수를 저장해주세요.
	      for(int i=0;i<datas.length;i++) {
	         System.out.print((i+1)+"번째 정수 입력 >> ");
	         datas[i]=sc.nextInt();
	      }

	      // 이후 정수를 한번더 입력받습니다.
	      int input;
	      while(true) {
	         System.out.print("값을 알고싶은 번째를 입력해주세요. >> ");
	         input=sc.nextInt();
	         if(1<=input && input<=datas.length) {
	            break;
	         }
	         System.out.println("1~"+datas.length+" 사이의 정수로 입력해주세요!");
	      }

	      // 입력받은 정수번째에 저장된 공간의 정수를 출력해주세요.
	      System.out.println(input+"번째 데이터는 "+datas[input-1]);


	}

}
