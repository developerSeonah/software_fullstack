package class06;

// 특정 멤버변수의 값을 반드시 넣도로 "강제"하고 싶을 때?
// "강제" : 개발자 입장에서 좋은 것! 실수를 줄여준다.
// 멤버 변수을 값을 '강제'하고 싶을 때
// == 생성자를 선언(정의) 하면 된다.

class Pokemon {
	String name;
	int level;
	int exp;
	
	// 멤버 변수의 값을 강제하고 싶을 때
		Pokemon(String name){
			this.name = name;
			// 외부에서 받아온 name 값을
			// 멤버변수 name에 저장
			// this를 생략해도 되지만 헷갈림 방지를 위해 반드시 사용
			// 멤버 변수가 조금만 많아져도 알 수 없으므로 꼭 멤버변수와 동일한 이름 작업을 하기
			
			this.level = 5;
			this.exp = 0;	// 모든 멤버변수 초기화를 직접 작성하는 것을 권장
		}
	
	void hello() {
		System.out.println(this.name);
		System.out.println("Lv. "+this.level);
		System.out.println("exp "+this.exp);
		// public static 사용 안 하는 이유
		// public : 누구나가 아닌 Pokemon만 쓸 수 있기 때문에
		// static : 객체와 무관하지 않기 때문에
	}
}		

public class Test01 {
	public static void main(String[] args) {
		
		Pokemon pika = new Pokemon("피카츄");
		Pokemon fire = new Pokemon("파이리");
		
//		pika 내부의 멤버변수 name = "피카츄";
//		pika.멤버변수 접근 연산자
//		pika.name = "피카츄";		// .멤버(변수)접근 연산자
//		fire.name = "파이리";
		
		pika.hello();
		fire.hello();
		
		
	}
}
