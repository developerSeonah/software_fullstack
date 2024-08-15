package service.model;

// MVC 패턴에서 data를 VO, DTO라고 함
// 지금까지 불러왔던 데이터
public class StudentDTO {
	// 멤버 변수
	private int num;
	private String name;
	private int score;
	
	// 게터,세터
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "StudentDTO [num=" + num + ", name=" + name + ", score=" + score + "]";
	}
}
