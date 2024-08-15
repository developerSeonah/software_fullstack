package class06;

public class Test02 {
	
	public static void test(int[] data) {
		data[0] = 0;
	}

	public static void main(String[] args) {
		
		// new 연산자 : 개발자 메모리 영역에 공간을 만들어줘
		// 		힙메모리 영역에 만든 배열의 주소는 메인 메모리에 저장
		// 힙메모리는 메인에도 영향을 줌
		// 메소드로 받을 때 주소값을 받음
		int[] datas = new int[3];
		for (int i = 0; i < 3; i++) {
			datas[i] = (i+1)*10;
		}
		
		System.out.print("[ ");
		for (int data:datas) {
		//forEach문, 향상된 for문, 배열과 함께 사용하는 for문
		//for(배열에 저장된 자료형 변수명: 배열명)
		//배열의 크기만큼 수행함
		// index[0]부터 변수가 해당 안덱스의 데이터를 대신함
			System.out.print(data + " ");
			
		}
		System.out.println("]");
		
		
		test(datas);
		//new로 제작한 변수를 전달하는 함수
		//call by reference(참조에 의한 호출)
		//    인자에 대해서 주고받는 것에 서만 해당
		
		System.out.print("[ ");
		for (int data:datas) {
			System.out.print(data + " ");
			
		}
		System.out.println("]");

	}

}
