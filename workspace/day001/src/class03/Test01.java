package class03;
// package는 class들을 보관하는 단위
// class03이라는 이름의 class 보관함이 있다.

public class Test01 {
// public : 공개범위를 의미함. <-> private
//			모두에게 공개 <-> 모두에게 은닉
//			java를 처음 개발한 사람들은 "모든 개발자들에게 널리 이롭게 할 코드"가 필요해서 만듬
//			java는 기본적으로 공개 정책(public) <-> C는 기본적으로 정보은닉체제(private)
// class : java의 기본단위
// Test01이라는 이름의 class 파일이 공개적으로 사용할 수 있게 되어있다.
// 클래스명 규칙 : 대문자로 시작 <-> 메소드, 변수,... 소문자로 시작
	
	public static void main(String[] args) {
		// static : "객체와 무관하게"
		// void : 무(없다)
		// void main(String[] args)
		// ▶ output 함수명(input)
		// input으로 String[] args을 가지고, output으로 void(아무것도 반환하지 않는)를 가지는 main이라는 이름의 함수
		// main기능의 함수가 객체와 무관하게 공개적으로 존재한다.

	}
}