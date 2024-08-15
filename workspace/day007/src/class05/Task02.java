package class05;

// Animal 클래스
class Animal{
	// 멤버변수
	String type;	// 종
	String name;	// 이름
	
	// 생성자(종은 강제)
	// 종 입력
	Animal(String type){
		this(type, "무명");
	}
	// 종과 이름 입력
	Animal(String type, String name){
		this.type = type;
		this.name = name;
	}
	
	//함수
	void hello() {
		System.out.println("Animal 울음소리");
	}
}

// Cat 클래스
class Cat extends Animal{
	// 멤버변수
	
	// 생성자
	Cat(){
		this("길냥이");
	}
	// 이름 입력
	Cat(String name){
		super("고양이", name);
	}
	
	// 함수
	@Override
	void hello() {
		System.out.println("야옹");
	}
}

// Dog 클래스
class Dog extends Animal{
	// 멤버변수
	
	// 생성자
	Dog(){
		this("검둥이");
	}
	// 이름 입력
	Dog(String name){
		super("개", name);
	}
		
	// 함수
	@Override
	void hello() {
		System.out.println("멍멍");
	}
}

public class Task02 {
	public static void main(String[] args) {
		
		Cat	c = new Cat();
		c.hello();
		
		Dog d = new Dog();
		d.hello();
	}

}
