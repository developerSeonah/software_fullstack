package model;

import java.util.ArrayList;

public class BoardDAO {
	private ArrayList<BoardDTO> datas;

	// 생성자
	public BoardDAO() {
		datas = new ArrayList<BoardDTO>();
	}

	public boolean insert(BoardDTO boardDTO) {
		// 글 작성
		System.out.println("   BoardDAO.insert()  시작");
		
		// 새로운 객체를 생성
		BoardDTO data = new BoardDTO();

		// 인자의 boardDTO의 값을 받아옴(번호, 제목, 내용, 작성자)
		data.setNum(boardDTO.getNum());
		data.setTitle(boardDTO.getTitle());
		data.setContent(boardDTO.getContent());
		data.setWriter(boardDTO.getWriter());
		// 조회수는 0으로 시작
		data.setCnt(0);

		// 현재 데이터 목록에 data를 추가
		this.datas.add(data);

		System.out.println("   BoardDAO.insert()  성공");
		return true;
	}
	public boolean update(BoardDTO boardDTO) {
		// 내용 변경
		System.out.println("   BoardDAO.update()  시작");

		// boardDTO에서 번호 값과 일치하는 게시글을 찾음
		// 원본 데이터 (this.datas)의 데이터들을 차례로 불러오면서 (for each)
		for(BoardDTO data : this.datas) {
			// 만약 번호가 일치한다면
			if(data.getNum() == boardDTO.getNum()) {
				// 값을 변경하기
				data.setContent(boardDTO.getContent());
				// 조회수 1증가
				data.setCnt(data.getCnt()+1);
				// 성공(true)로 반환
				System.out.println("   BoardDAO.update()  성공");
				return true;
			}
		}
		// 실패 시
		System.out.println("   BoardDAO.update()  실패");
		return false;
	}
	public boolean delete(BoardDTO boardDTO) {
		// 글 삭제
		System.out.println("   BoardDAO.update()  시작");
		
		// boardDTO.getNum과 일치하는 게시글을 찾음
		// 원본 데이터를 차례로 불러옴
		// 인덱스 위치를 알아야하므로 for문으로 작성
		for(int i = 0; i < this.datas.size(); i++) {
			// 만약 두 getNum이 일치 한다면
			if(this.datas.get(i).getNum() == boardDTO.getNum()) {
				// 해당 data를 삭제
				this.datas.remove(i);
				// 성공(true)로 반환
				System.out.println("   BoardDAO.delete()  성공");
				return true;
			}
		}
		// 실패 시
		System.out.println("   BoardDAO.delete()  실패");
		return false;
	}

	public ArrayList<BoardDTO> selectAll(BoardDTO boardDTO){
		System.out.println("   BoardDAO.selectAll()  시작");
		ArrayList<BoardDTO> datas = new ArrayList<BoardDTO>();

		// condition 값에 따라 기능이 달라짐
		// 글 전체 출력 (boardDTO.getCondition이 ALL)
		if(boardDTO.getCondition().equals("ALL")) {
			// 새로만든 datas 배열에 원본 데이터를 넣어줌
			for(BoardDTO data : this.datas) {
				datas.add(data);
			}
		}
		// 제목으로 검색 (boardDTO.getCondition이 SEARCHTITLE)
		if(boardDTO.getCondition().equals("SEARCHTITLE")) {
			// 원본 데이터 값들을 불러옴
			for(BoardDTO data : this.datas) {
				// 만약 data의 제목이 인자의 제목값과 같다면
				if(data.getTitle().contains(boardDTO.getTitle()))
					// datas에 값을 넣어라 
					datas.add(data);
			}
		}
		// 이름으로 검색 (boardDTO.getCondition이 SEARCHNAME)
		if(boardDTO.getCondition().equals("SEARCHNAME")) {
			// 원본 데이터 값들을 불러옴
			for(BoardDTO data : this.datas) {
				// 만약 data의 작성자 값이 인자의 작성자값과 같다면
				if(data.getWriter().contains(boardDTO.getWriter()))
					// datas에 값을 넣어라 
					datas.add(data);
			}
		}

		// 값이 기능에 따라 값이 입력된 datas를 반환
		System.out.println("   BoardDAO.selectAll()  종료");
		return datas;
	}

	public BoardDTO selectOne(BoardDTO boardDTO) {
		// 글 1개 선택
		System.out.println("   BoardDAO.selectOne()  시작");
		
		// 원본 데이터에서 번호(PK)가 일치하는 값을 찾아봄
		for(BoardDTO data : this.datas) {
			// 일치하는 값이 있다면
			if(data.getNum() == boardDTO.getNum()) {
				// data에 객체를 넣음
				return data; 
			}
		}
		
		System.out.println("   BoardDAO.selectOne()  데이터 없음");
		return null;
	}
}