package model;

//데이터 그 자체를 의미
//게시글
//속성 : PK(번호) / 제목 / 내용 / 조회수
public class BoardDTO {
	private int num;		// 번호
	private String title;	// 제목
	private String content;	// 내용
	int cnt;				// 조회수
	
	private String condition; // 개발자에게 필요한 데이터
	
	public int getNum() {
		return num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	@Override
	public String toString() {
		return "BoardDTO [num=" + num + ", title=" + title + ", content=" + content + ", cnt=" + cnt + "]";
	}
}
