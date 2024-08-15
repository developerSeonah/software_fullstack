package class01;

import java.util.ArrayList;

// 컬렉션 프레임워크
// 배열리스트

public class Test01 {
	public static void main(String[] args) {
		
		// 배열[] : 개수가 정해져있음
		// 배열리스트 : 개수 무제한 ◀
		// 모든 컬렉션들은 자료형을 제한하지 않고 저장할 수 있음
		// 그러나, 자료형 제한없이 사용하는 것은 개발자에게 불리함
		// 자료형 "강제"를 해야함
		// == 제네릭
		ArrayList<Integer> al = new ArrayList<Integer>();	// 제네릭함. <Integer>
		// 요소 추가
		al.add(10);
		al.add(20);
		al.add(30);
		// 인덱스 컨트롤
		al.add(1, 123);	// 덮어쓰기가 가능, (위치, 넣을 값), 오버로딩
		boolean ans = al.contains(124);
		
		System.out.println(ans);
		System.out.println(al.get(1));
		System.out.println(al);
		// 최상위 Object 클래스로부터
		// toString()을 '오버라이딩' 했다.
		
		//al.clear();	// 클리어 가능
		ans = al.isEmpty();     // 비어있는지 확인
		System.out.println(ans);
		System.out.println(al);
		System.out.println(al.size()); 	// == .length
		//al.remove(1);    // 제거, (위치)
		//System.out.println(al.size());
		System.out.println(al.lastIndexOf(20)); // 배열의 마지막에서 부터 요소가 20인 위치를 찾음
	}

}
