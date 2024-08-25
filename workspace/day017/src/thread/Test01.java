package thread;

// [스레드]
// : 실직적으로 일을 수행하는 주체
class Thread01 extends Thread{

	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println(i+" 첫번째 스레드 일하는 중....");
		}
	}
	
}

// 인터페이스를 "강제"할 때 쓰는 이유 == 추상 메서드의 오버라이딩 "강제"
class Thread02 implements Runnable{

	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println(i+" 두 번째 스레드 일하는 중....");
		}
	}
	
}

public class Test01 {
	public static void main(String[] args) {
		Thread01 t1 = new Thread01();
		
		// Tread02는 상속하지 않았기 때문에 Tread타입은 아님
		// Tread에게 Tread02를 쥐어주는 방법으로 생성
		Thread t2 = new Thread(new Thread02());
		
		t1.start();
		t2.start();
	}
}