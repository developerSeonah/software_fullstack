package model;

// 번호(PK)  제목  내용  조회수  작성자
public class BoardDTO {
	private int num;
	private String title;
	private String content;
	private int cnt;
	private String writer;
	// 상대 DTO(data)의 PK값을 받아오는 속성(필드, 멤버변수)
			// == FK
	
	private String condition; // 개발자에게 필요한 데이터
	
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [num=" + num + ", title=" + title + ", content=" + content + ", cnt=" + cnt + ", writer="
				+ writer + "]";
	}
}
