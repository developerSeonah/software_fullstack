package class02;

import java.util.HashMap;
import java.util.Map;

/*
Point 클래스가 있습니다.
점은 x,y좌표를 속성으로 갖습니다.
x,y 좌표 위치를 반드시 정하여 point 객체를 생성합니다.
101번 점 p1, 102번 점 p2 를 생성하여
map 컬렉션으로 관리해주세요
 */

// Point class
class Point{
	// 멤버 변수
	// 정수형 변수 x, y
	private int x;
	private int y;

	// 생성자
	// x, y (강제)
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y +"]";
	}
}

public class Task02 {
	public static void main(String[] args) {
		// 맵 컬렉션 객체 생성
		// key : 정수, 데이터 : Point
		Map<Integer, Point> map = new HashMap<Integer, Point>();
		
		// PK 값
		int PK = 101;
		
		// 맵 생성
		map.put(PK++, new Point(10,11));
	    map.put(PK++, new Point(12,22));
	    map.put(PK++, new Point(100,200));

		// 맵 출력
		System.out.println(map);
	}
}
