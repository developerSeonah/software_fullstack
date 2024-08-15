package model;

import java.util.ArrayList;

// CRUD(비즈니스 메서드, 핵심 관심, 핵심 로직
// CRUD 인자를 모두 DTO로 통합하자 == 코드 결압도로 낮추기 위한
public class BoardDAO {
	private ArrayList<BoardDTO> datas;	// DB 역할
	public BoardDAO() {
		this.datas = new ArrayList<BoardDTO>();
		
		// 샘플 데이터 추가할 수 있는 공간
		BoardDTO data1=new BoardDTO();
		data1.setNum(101);
		data1.setTitle("샘플");
		data1.setContent("ㅈㄱㄴ");
		data1.setCnt(0);
		this.datas.add(data1);
		
		BoardDTO data2=new BoardDTO();
		data2.setNum(102);
		data2.setTitle("샘플2");
		data2.setContent("안녕?");
		data2.setCnt(0);
		this.datas.add(data2);
	}
	public boolean insert(BoardDTO boardDTO) {
		System.out.println("   로그 : DAO insert() 시작");
		BoardDTO data = new BoardDTO();
		data.setNum(boardDTO.getNum());
		data.setTitle(boardDTO.getTitle());
		data.setContent(boardDTO.getContent());
		data.setCnt(0);
		this.datas.add(data);
		System.out.println("   로그 : DAO insert() 성공");
		return true;
	}
	public boolean update(BoardDTO boardDTO) {
		System.out.println("   로그 : DAO update() 시작");
		
		// 만약 글 선택을 작동했다면 == condition이 cnt라면 
		if(boardDTO.getCondition().equals("CNT")) {
			for(BoardDTO data : this.datas) {
				if(data.getNum() == boardDTO.getNum()) {
					data.setCnt(data.getCnt()+1); // 현재 방문자수 +1;
					System.out.println("   로그 : DAO update() 성공");
					return true;
				}
			}
		}
		// 만약 내용을 변경했다면 == condition이 CONTENT라면 
		if(boardDTO.getCondition().equals("CONTENT")) {
			for(BoardDTO data : this.datas) {
				System.out.println(data.getContent());
				if(data.getNum() == boardDTO.getNum()) {
					data.setContent(boardDTO.getContent());
					data.setCnt(data.getCnt()+1); // 현재 방문자수 +1;
					System.out.println("   로그 : DAO update() 성공");
					return true;
				}
			}
		}
		
		if(boardDTO.getCondition().equals("TITLE")) {
			for(BoardDTO data : this.datas) {
				System.out.println(data.getContent());
				if(data.getNum() == boardDTO.getNum()) {
					data.setTitle(boardDTO.getTitle());
					data.setCnt(data.getCnt()+1); // 현재 방문자수 +1;
					System.out.println("   로그 : DAO update() 성공");
					return true;
				}
			}
		}
		System.out.println("   로그 : DAO update() 실패");
		return false;
	}
	
	public boolean delete(BoardDTO boardDTO) {
		System.out.println("   로그 : DAO delete() 시작");
		for(int i = 0; i < this.datas.size(); i++) {
			if(this.datas.get(i).getNum() == boardDTO.getNum()) {
				this.datas.remove(i);
				System.out.println("   로그 : DAO delete() 성공");
				return true;
			}
		}
		System.out.println("   로그 : DAO delete() 실패");
		return false;
	}

	public ArrayList<BoardDTO> selectAll(BoardDTO boardDTO) {
		System.out.println("   로그 : DAO selectAll() 시작");
		// 새로운 배열을 만듬
		ArrayList<BoardDTO> al = new ArrayList<BoardDTO>();

		// 만약 전체 출력이었다면
		if(boardDTO.getCondition().equals("All")) {
			System.out.println("   로그 : DAO selectAll() 끝");
			return this.datas; // 원본을 직접 주는 코드는 좋은 코드는 아님
		}
		// 제목으로 검색했다면
		if(boardDTO.getCondition().equals("TITLE")) {
			// 기존 배열을 전체 반복
			for(BoardDTO data : this.datas) {
				// 만약 검색어를 포함하는 값이 있다면
				if(data.getTitle().contains(boardDTO.getTitle())) {
					// 새로운 배열에 추가함
					al.add(data);
					System.out.println("   로그 : DAO selectAll() 배열 추가");
				}
			}
		}
		System.out.println("   로그 : DAO selectAll() 끝");
		return al;
	}
	
	public BoardDTO selectOne(BoardDTO boardDTO) {
		System.out.println("   로그 : DAO selectOne() 시작");
		for(BoardDTO data : this.datas) {
			if(data.getNum() == boardDTO.getNum()) {
				return data;
			}
		}
		System.out.println("   로그 : DAO selectOne() 끝");
		return null;
	}
}