package class02;

import java.util.HashMap;
import java.util.Map;

// 컬렉션
// 맵
public class Test02 {
	public static void main(String[] args) {
		
		// key - value
		// 키 값 - 데이터 값
		// 키 : 다른 데이터와 중복 xxx == PK
		// 데이터 : 실제 데이터
		// Map<키 값의 자료형, 데이터의 값의 자료형>
		
		// 맵은 종류가 많아서 new로 만들 수 없다.
		// 맵 종류에서 지정해서 만들어야 함
		// ex) 포켓몬스터 = new 피카츄;
		// 키 컨트롤
		// 한 쌍(키, 데이터)이 하나의 데이터
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1001, "홍길동");
		map.put(1002, "아무무");
		System.out.println(map.containsKey(1001));
		System.out.println(map.containsValue("티모"));
		//map.clear();
		//System.out.println(map.isEmpty());
		System.out.println(map.size());
		System.out.println(map);
	}

}
