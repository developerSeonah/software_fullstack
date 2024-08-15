package class05;

import java.util.Random;

interface CharacAction {
	boolean attack();
}

// 캐릭터 클래스
class Charac implements CharacAction{ //Fight 인터페이스를 가져옴
	// 멤버변수
	private String name;// 이름 (강제)
	private int level;// 레벨 (10레벨부터 시작)
	private Weapon weapon;// 무기 (class Weapon)
	
	// 생성자
	public Charac(String name) {
		this(name, null);  // null == 없다.
	}
	public Charac(String name, Weapon weapon) {
		this.name = name;	// 이름, 인자에서 받음
		this.level = 10;	// 레벨 = 10;
		this.weapon = weapon;// 무기 = 무기 객체
	}
	
	// getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	
	@Override
	//attack함수
	public boolean attack() {
		// 무기가 있는 경우
		if(this.weapon != null) {
			// 무기가 있는 경우
			//무기 객체.attack();
			//만약 공격에 성공했다면
			if(this.weapon.attack()) {
				this.level++;
				System.out.println("무기 공격 성공!");
				System.out.println("현재 레벨은 "+ this.level);
				return true;
			}
			System.out.println("무기 공격 실패...");
		}
		// 무기가 없는 경우
		else {
			System.out.println("맨손으로 공격");
		}
		return false;
	}
}

// 무기 클래스
abstract class Weapon implements CharacAction{
	// 멤버 변수
	String name; // 무기 이름
	
	// 생성자
	public Weapon(String name) {
		this.name = name;
	}

	@Override
	abstract public boolean attack();	
}

class Gun extends Weapon{
	private Random rand = new Random();
	
	Gun(){
		super("총");
	}

	@Override
	public boolean attack() {
		if(rand.nextBoolean()) { // 성공했다면
			System.out.println("탕!");
			return true;
		}
		System.out.println("어라?");
		return false;
	}
}

public class Task01 {
	public static void main(String[] args) {
		
		Weapon w = new Gun();
		Charac c = new Charac("하나", w);
		c.attack();
		c.attack();
	}

}
