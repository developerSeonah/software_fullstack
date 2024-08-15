package class02;

class Animal{
	String type;
	String name;
	
	Animal(String type){
		this(type, "무명");
		System.out.println("로그 01");
	}
	Animal(String type, String name){
		this.type = type;
		this.name = name;
		System.out.println("로그 02");
	}
	
	void hello() {
		System.out.println(this.type + " "+this.name);
	}
}
class Cat extends Animal{
	Cat(){
		this("나비");		//자식 생성자에서
		System.out.println("로그 03");
	}
	Cat(String name){
		super("고양이", name);	// 부모 생성자에서
		System.out.println("로그 04");
	}
}

public class Test02 {
	   public static void main(String[] args) {
		      Cat 길고양이=new Cat();
		      System.out.println();
		      Cat cat=new Cat("구동이");
		      길고양이.hello();
		      cat.hello();
		   }
}
