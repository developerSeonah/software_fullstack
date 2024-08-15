package controller;

import java.util.ArrayList;

import model.BoardDAO;
import model.BoardDTO;
import model.MemberDAO;
import model.MemberDTO;
import view.LoginView;
import view.LogoutView;
import view.MainView;

// 로그아웃
public class Controller {
	private BoardDAO boardDAO;
	private MemberDAO memberDAO;
	private MainView mainView;
	private LoginView loginView;
	private LogoutView logoutView;
	private int PK;
	// 현재 로그인 상태인지 아닌지를 판단하는 변수
	private MemberDTO user;

	// 생성자
	public Controller(){
		this.boardDAO = new BoardDAO();
		this.memberDAO = new MemberDAO();
		this.mainView = new MainView();
		this.loginView = new LoginView();
		this.logoutView = new LogoutView();
		this.PK = 1001;
		// 맨 처음은 당연히 로그아웃 상태
		this.user = null;
	}

	public void start() {
		while(true) {
			// 메뉴 출력 (기본 상황과 로그아웃인 상황)
			mainView.printMenu();
			// 로그아웃 상태인지를 판단
			// 로그아웃 상태라면
			if(this.user == null) {
				logoutView.printMenu();
			}
			// 로그인 상태라면
			else {
				loginView.printMenu();
			}
			// 메뉴를 입력받음
			int menu = mainView.inputMenuNum();

			// 종료(0이라면)
			if(menu == 0) {
				mainView.printExit();
				break;
			}

			// 글 전체 출력
			else if(menu == 1) {
				// condition에 "ALL"을 인자로 넣을 객체(boardDAO) 생성 
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setCondition("ALL");
			}
			// 검색 : 제목
			else if(menu == 2) {

			}
			// 검색 : 작성자
			else if(menu == 3) {

			}
			// 글 1개 선택
			else if(menu == 4) {

			}
			// 로그인
			else if(menu == 5) {
				// V에서 사용자에게 아이디, 비밀번호를 받아올 예정
				// 값을 받아오는 것이라 따로 생성하진 않았다.
				MemberDTO data = logoutView.inputLoginInfo();

				// DB에게 사용자가 입력한 아이디, 비밀번호를 전달해주고
				// (얘가 있는지
				// 있다면 비밀번호는 맞는지 등등을 다 확인해서)model 
				// 반환받음
				data = memberDAO.selectOne(data);

				// 로그인 됐다. 안 됐다. 
				// V에게 알맞은 화면을 보여달라고 알려주기
				// 만약 데이터가 있다면 
				if(data != null) {
					user = data;
					mainView.printTrue();
				}
				else {
					mainView.printFalse();
				}
			}
			// 회원가입
			else if(menu == 6) {

			}
			// 로그아웃
			else if(menu == 7) {
				// DAO와 관련없이
				// Controller에 있는 user하고만 관련 있다.
				// 로그아웃 함 == user의 데이터를 비움
				this.user = null;
				// 성공 출력
				mainView.printTrue();
			}
			// 글 작성
			else if(menu == 8) {
				// 로그인 한 사람이 글을 쓸 건데
				// 제목, 내용을 작성하면
				BoardDTO data = loginView.inputBoardData();
				data.setNum(PK++);
				data.setWriter(user.getMid());
				
				// Model한테 제목, 내용 누가 썼는지 까지 정보를 보내주면
				// M이 DB에 Insert()하겠지
				boolean flag = boardDAO.insert(data);
				
				// 잘 작성 되었었으면 T
				if(flag) {
					mainView.printTrue();
				}
				// 아니면 F
				else {
					mainView.printFalse();
				}
			}
			// 글 삭제
			else if(menu == 9) {		// (재희)
				// 삭제는 로그인을 한 상태에서만 가능
				// 로그인을 한 상태인지 확인
				// 만약 로그인을 안 한 상태라면
				if(this.user == null) {
					// 실패를 출력하고, 밑의 코드를 건너뜀
					mainView.printFalse();
				}
				
				// 인자로 사용할 BoardDTO 객체 생성
				BoardDTO data = new BoardDTO();
				
				// 사용자가 삭제할 수 있는 게시글 범위를 제한하기 위해 mid를 data에 입력
				// writer에 mid를 받음(FK)
				data.setWriter(this.user.getMid());
				// 이름 검색을 위해 condition을 넣음 
				data.setCondition("SEARCHNAME");
				
				// M에게 해당 작성자의 글 목록들을 새로 생성
				ArrayList<BoardDTO> datas = boardDAO.selectAll(data);
				
				// num(PK) 값 입력 안내 출력하고, 입력받음 (V)
				// 로그인을 한 상태이므로 loginView
				// 자신이 쓴 글 목록을 보여주도록 함
				int num = loginView.inputDeleteNum(datas);
				
				// 인자(객체)에 num 값을 집어넣음
				data.setNum(num);
				
				// BoardDAO.Delete에 인자(객체) 전달
				// 성공, 실패값 반환받기
				boolean flag = boardDAO.delete(data);
				
				// 삭제 성공했다면 T
				if(flag) {
					mainView.printTrue();
				}
				// 아니면 F
				else {
					mainView.printFalse();
				}
			}
			// 글 내용 변경
			else if(menu == 10) {		//(종민)
//				// 인자로 사용할 객체 생성
//				BoardDTO boardDTO = new BoardDTO();
//				
//				// 객체에 값을 넣음
//				boardDTO.setCondition("USERALL");
//				boardDTO.setWriter(user.getMid());
//				
//				ArrayList<BoardDTO> datas = boardDAO.selectAll(boardDTO);
//				if(datas.size()>0) {
//					mainView.printAL(datas);
//				}
//				else {
//					mainView.printFalse();
//					continue;
//				}
//				
//				BoardDTO data = new BoardDTO();
//				data.setNum(loginView.inputNum());
//				data.setContent(loginView.inputContent());
//				data.setWriter(user.getMid());
//				System.out.println("로그01");
//				System.out.println(data);
//				boolean flag = boardDAO.update(data);
//				
//				// 삭제 성공했다면 T
//				if(flag) {
//					mainView.printTrue();
//					// 로그아웃 됨
//					this.user = null;
//				}
//				// 아니면 F
//				else {
//					mainView.printFalse();
//				}

			}
			// 회원 삭제
			else if(menu == 11) {		// (재희)
				// 삭제는 로그인을 한 상태에서만 가능
				// 로그인을 한 상태인지 확인
				// 만약 로그인을 안 한 상태라면
				if(this.user == null) {
					// 실패를 출력하고, 밑의 코드를 건너뜀
					mainView.printFalse();
				}
				
				// 탈퇴 확인 작업
				// 로그인을 한 상태이므로 loginView
				boolean ansCheck = loginView.isDelete();
				
				// 탈퇴하지 않는다면 밑의 코드를 건너뜀
				if(!ansCheck) {
					continue;
				}
				
				// 인자로 사용할 MemberDTO 객체 생성
				MemberDTO data = new MemberDTO();
				
				// 이미 로그인을 한 상태로, mid가 있음
				// 인자(객체)에 mid 값을 집어넣음
				data.setMid(this.user.getMid());
				
				// MemberDAO.Delete에 인자(객체) 전달
				// 성공, 실패값 반환받기
				boolean flag = memberDAO.delete(data);
				
				// 삭제 성공했다면 T
				if(flag) {
					mainView.printTrue();
					// 로그아웃 됨
					this.user = null;
				}
				// 아니면 F
				else {
					mainView.printFalse();
				}
			}
		}
	}
}
