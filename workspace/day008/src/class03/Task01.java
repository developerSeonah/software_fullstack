package class03;

import java.util.Random;

class Tool{
	String name;
	
	// 생성자
	Tool(String name){
		this.name = name;
	}
	
	void action() {
		System.out.println("도구 사용");
	}
}
class Fishing extends Tool{
	Fishing() {
		super("낚시대");
	}

	@Override
	void action() {
		System.out.println("생선 낚시");
	}
	
}
class Dragonfly extends Tool {
	   Dragonfly(){
	      super("잠자리채");
	   }
	   @Override
	   void action() {
	      System.out.println("곤충채집");
	   }
	}

class Shovel extends Tool{
	Shovel() {
		super("삽");
	}
	
	@Override
	void action() {
		System.out.println("땅파기");
	}
	
}


class Resident{
	// 멤버변수
	String type;			// 무조건 있음
	String name;			// 주민을 생성할 때 반드시 설정하면서 만듦
	
	// 클래스 변수;
	// 행복함(0) / 무난함(1) / 슬픔(2) / 화남(3)
	static String[] datas = {"행복해", "무난해", "슬퍼", "화났어"};
	static Random rand = new Random();
	
	// 생성자
	// 이름과 타입이 반드시 들어가야함
	Resident(String type, String name){
		this.type = type;
		this.name = name;
	}
	
	//함수
	void hello() {
		// 정수 1~4 중 랜덤하게 값을 받음
		int feel = rand.nextInt(Resident.datas.length);
		System.out.print(this.name+"은/는 "+datas[feel]);
	}
	void action(Tool tool) {	// 자식 클래스에서 변화 x
		tool.action();		// 동적바인딩 -> 다형성 실현
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  this.type+" 주민 "+this.name;
	}
	
}

class Cat extends Resident{
	// 멤버변수는 같음
	
	// 생성자
	// 타입은 고양이 고정으로 생성,
	// 이름은 반드시 받음
	Cat(String name){
		// 부모 생성자 이용
		super("고양이", name);
	}
	
	// 함수
	// hello() 출력물 뒤에 야옹 붙음
	// action()은 그대로
	@Override
	void hello() {
		super.hello();
		System.out.println(", 야옹");
	}
}

class Frog extends Resident{
	// 멤버변수는 같음
	
	// 생성자
	// 타입은 개구리 고정으로 생성,
	// 이름은 반드시 받음
	Frog(String name){
		// 부모 생성자 이용
		super("개구리", name);
	}
	
	// 함수
	// hello() 출력물 뒤에 개굴 붙음
	// action()은 그대로
	@Override
	void hello() {
		super.hello();
		System.out.println(", 개굴");
	}
}

public class Task01 {
	public static void main(String[] args) {
		// 주민 3명 생성
		Resident[] datas = new Resident[3];
		
		// 주민 샘플 데이터
		datas[0] = new Cat("히죽이");
		datas[1] = new Frog("레이니");
		datas[2] = new Frog("아이다");
		
		for (Resident r1:datas) {
			r1.hello();
		}
		for (Resident r1:datas) {
			Tool tool = new Fishing();
			r1.action(tool);
		}
		for (Resident r1:datas) {
			System.out.println(r1);
	        //System.out.println(r1.toString());

		}
	}	
}