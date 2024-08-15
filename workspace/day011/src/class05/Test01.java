package class05;

// 설계★
// 속성: 이름,레벨,공격력,...
// 메서드: Q(),W(),E(),R(),귀환(),...
abstract class Champ {
   private String name; // private 멤버변수
   private int level; // 속성,필드,attribute,property
   Champ(String name){ // 생성자 == 멤버변수 초기화
      this.name=name;
      this.level=3;
   }
   abstract public void Q(); // 메서드
   abstract public void W(); // 하위 클래스들아, 잊지말고 재정의해! (강제)
   public void B() { // 귀환
      System.out.println("집으로 돌아가기");
   }
   public String getName() { // getter, setter
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
   @Override
   public String toString() { // toString()
      return "Champ [name=" + name + ", level=" + level + "]";
   }
}
// 티모,아리,...
class Teemo extends Champ {

   Teemo() {
      super("티모");
   }
   @Override
   public void Q() {
      System.out.println("독침");
   }
   @Override
   public void W() {
      System.out.println("빨리가기");
   }
   
}
class Ari extends Champ {

   Ari() {
      super("아리");
   }
   @Override
   public void Q() {
      // 추상 메서드의 오버라이딩 강제 덕분에
      // 쉽고 빠르게 잊지않고 메서드 재정의 가능!!!
      System.out.println("구슬");
   }
   @Override
   public void W() {
      System.out.println("불꽃");
   }
   
}

public class Test01 {

}
