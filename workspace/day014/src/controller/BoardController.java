package controller;

import java.util.ArrayList;

import model.BoardDAO;
import model.BoardDTO;
import view.BoardView;

public class BoardController {
	// C는 V, M을 멤버변수로 반드시 갖는다.
	private BoardView view;
	private BoardDAO model;
	private int PK;
	public BoardController() { // 멤버변수 초기화 == 생성자
		this.view = new BoardView();
		this.model = new BoardDAO();
		this.PK = 102;
	}
	
	public void start() {
		while (true) {
			// 사용자에게 메뉴목록을 보여주면,
			view.printMenuList();
			// 사용자가 원하는 메뉴를 입력하겠지?
			int action = view.inputMenuNum();
			
			if(action == 0) { // 종료
				view.exit();
				break;
			}
			else if (action == 1) {	// 게시글 작성
				// 객체를 하나 생성해서 값을 담았다. (view)
				// 값들을 담아놓은 객체를 반환해서 객체 data에 담음 (controller)
				BoardDTO data = view.boardWrite();
				
				// 인자로 넣어줄 객체를 생성하여, 게시글 객체의 생성자요소를 담음
				// 정확도와 위조방지를 위해 1번 사용할 때 1개의 객체를 만듦
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setNum(PK++);
				boardDTO.setTitle(data.getTitle());
				boardDTO.setContent(data.getContent());
				// model의 insert함수의 인자로 boardDTO를 넣고 생성이 잘 됐는지 반환값을 받음
				boolean flag = model.insert(boardDTO);
				// 만약 생성이 됐다면
				if(flag) {
					view.printTrue();;
				}
				// 생성이 되지 않았다면
				else {
					view.printFalse();;
				}
			}
			else if (action == 2) {	// 전체 목록 출력
				// 인자는 항상 들어가야함. 인자가 1개 있는 함수밖에 없으니까
				// 그러므로 인자값이 필요하지 않더라도 항상 인자로 들어갈 객체는 생성해야함
				BoardDTO boardDTO = new BoardDTO();
				
				// condition 값으로 어떠한 상황인지 작성
				boardDTO.setCondition("All"); 		// 모든 값
				view.printBoardList(model.selectAll(boardDTO));				
			}
			else if (action == 3) {	// 글 1개 검색 == 글 선택
				// 검색할 게시글 번호를 입력받음
				int num = view.inputNum();
				
				// 숫자를 담을 객체 생성
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setNum(num);// 숫자를 담음
				
				// 선택한 데이터를 찾아서 가져옴
				// selectOne은 PK값을 이용하여 1개의 값만 가져오므로 condition이 필요없음
				BoardDTO data = model.selectOne(boardDTO);
				// 방문 즉시 조회수++
				boardDTO.setCondition("CNT"); 	// 조회수
				// update를 사용후 조회수가 잘 올라갔는지 반환값으로 받음
				boolean flag = model.update(boardDTO);
				// 만약 update에 실패했다면
				if(!flag) {
					view.printFalse();
					// 그 다음이 실행되면 안 되므로 스킵
					continue;
				}
				
				// 글을 검색했을 때 데이터가 있다면
				if(data != null) {
					// 출력
					view.printBoardData(data);
				}
				else {
					view.printFalse();
				}
			}
			else if (action == 4) {		// 내용 변경
				// 게시글 번호 선택
				int num = view.inputNum();
				
				// 숫자를 담을 객체 생성
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setNum(num);// 숫자를 담음
				
				// 객체를 찾는 작업
				BoardDTO data = model.selectOne(boardDTO);
				
				// 존재하지 않을 때
				if(data == null) {
					view.printNullData();
					// 아래 프로그램 스킵
					continue;
				}
				
				// 내용을 입력받음
				String content = view.inputContent(); //내용을 입력하라고 하고 입력받아
				
				// 입력받은 타이틀 값을 넣어줌
				boardDTO.setContent(content);			// 내용은 새로 넣은 것
				// update되는 것은 content
				boardDTO.setCondition("CONTENT");
				// 선택한 번호의 게시글에 입력받은 내용을 업데이트
				// 성공했는지 안 했는지 판단을 반환값으로 받음
				boolean flag = model.update(boardDTO);
				
				// 업데이트에 성공했다면
				if(flag) {
					view.printTrue();;
				}
				else {
					view.printFalse();
				}
			}
			else if (action == 5) {		// 제목 변경
				// 게시글 번호 선택
				int num = view.inputNum();
				
				// 숫자를 담을 객체 생성
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setNum(num);// 숫자를 담음
				
				// 객체를 찾는 작업
				BoardDTO data = model.selectOne(boardDTO);
				
				// 존재하지 않을 때
				if(data == null) {
					view.printNullData();
					// 아래 프로그램 스킵
					continue;
				}
				
				// 제목을 입력받음
				String title = view.inputContent(); //내용을 입력하라고 하고 입력받아
				
				// 입력받은 타이틀 값을 넣어줌
				boardDTO.setContent(title);			// 내용은 새로 넣은 것
				// update되는 것은 title
				boardDTO.setCondition("TITLE");
				// 선택한 번호의 게시글에 입력받은 제목을 업데이트
				// 성공했는지 안 했는지 판단을 반환값으로 받음
				boolean flag = model.update(boardDTO);
				
				// 업데이트에 성공했다면
				if(flag) {
					view.printTrue();;
				}
				else {
					view.printFalse();
				}
			}
			else if (action == 6) {	//게시글 삭제
				// 게시글 번호 선택
				int num = view.inputNum();
				
				// 숫자를 담을 객체 생성
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setNum(num);// 숫자를 담음
				
				// 받은 번호로 객체를 찾고 삭제
				boolean flag = model.delete(boardDTO);
				
				// 삭제에 성공했다면
				if(flag) {
					view.printTrue();;
				}
				// 실패했다면
				else {
					view.printFalse();
				}	
			}
			else if (action == 7) {	//제목으로 검색
				// 제목을 입력하라는 출력과 값을 입력받음
				String searchKeyWord = view.inputTitle();
				
				// 제목를 담을 객체 생성, 담기
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setTitle(searchKeyWord);
				// 제목으로 검색
				boardDTO.setCondition("TITLE");
				
				// 키워드가 들어간 이름의 객체를 리스트로 가져옴
				ArrayList<BoardDTO> al = model.selectAll(boardDTO);
				
				// 찾은 데이터들을 출력, 데이터가 없다면 빈 검색창을 보여줌
				view.printSearchList(al);
			}
			else {
				System.out.println("다시 입력하세요");
			}
		}
	}
}