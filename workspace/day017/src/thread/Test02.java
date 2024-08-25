package thread;

class Person implements Runnable{  // 실질적으로 티켓을 구매하는 주체
	private TicketPage page;
	public Person(TicketPage page) {
		this.page = page;
	}
	
	@Override
	public void run() {
		this.page.buy();
	}
}

class TicketPage{
	private static int ticket=3;  // 공유자원
	public synchronized void buy() {  // 동기화 <-> 비동기적으로 일을 수행하는 스레드
		if(TicketPage.ticket > 0) {
			TicketPage.ticket--;
			// 현재 동작중인 스레드의 이름
			System.out.println(Thread.currentThread().getName()+"님이 티켓을 구매하셨습니다!");
		}
		else {
			System.out.println(Thread.currentThread().getName()+"님 티켓 구매 실패...ㅠ");
		}
	}
}

public class Test02 {
	public static void main(String[] args) {
		TicketPage page = new TicketPage();
		
		// 스레드 클래스는 생성자 오버로딩이 가능하다.
		Thread t1 = new Thread(new Person(page), "티모");
		Thread t2 = new Thread(new Person(page), "아리");
		Thread t3 = new Thread(new Person(page), "아무무");
		Thread t4 = new Thread(new Person(page), "럭스");
		Thread t5 = new Thread(new Person(page), "제드");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}