package view;

import model.MemberDTO;

public class LogoutView extends View { //로그 아웃 상황에서 보여줄 View

	public void printMenuList() {
		// 로그아웃 상태에서 나오는 메뉴판
		System.out.println("2.회원가입"); //"회원가입"
		System.out.println("3.로그인");  //"로그인"
		System.out.println("=====================");
	}

	public MemberDTO inputLoginInfo() {

		// "아이디 입력"
		System.out.println("아이디 입력: ");
		String Id = sc.next();

		// "비밀번호 입력"
		System.out.println("비밀번호 입력: ");
		String Pw = sc.next();

		// 받은 값들로 아이디 비밀번호 set
		MemberDTO data = new MemberDTO();// 반환 타입과 동일한 객체 생성
		data.setMid(Id); // 객체 내 아이디 설정
		data.setPassword(Pw); // 객체 내 비밀번호 설정

		return data;
		// DTO 변수 data로 값 반환
	}

	public void nameInUse() {// 중복아이디 안내 문구
		System.out.println("=================================");
		System.out.println("       동일한 아이디가 존재합니다!      ");
		System.out.println("=================================");
	}

	public String inputNewId() {
		String id;
		while (true) {
			// 신규 회원 가입
			// 아이디 입력 문구
			System.out.println("아이디 입력: ");
			id = sc.next();

			// 이 아이디로 가입을 계속하시겠습니까? (Y/N)
			System.out.println("=================================");
			System.out.println("해당 아이디로 가입 하시겠습니까? (Y/N)");
			System.out.println("=================================");
			System.out.println("입력하신 아이디: " + id); // ID 재확인 UI
			System.out.println("=================================");
			String idAnswer = sc.next(); //아이디 확인에 대한 답변 받기.

			if (idAnswer.equals("Y")) { // 답이 문자 'Y'라면
				break; // 반복문 종료// Id 값을 반환
			} else {
				continue;
			}
		}
		return id;
	}

	public String inputNewPw() {
		String pw;
		String pw2;
		while (true) {
			System.out.println("=================================");
			System.out.println("비밀번호: ");
			System.out.println("=================================");
			pw = sc.next();
			System.out.println("=================================");
			System.out.println("비밀번호 확인: ");
			System.out.println("=================================");
			pw2 = sc.next();
			if (pw.equals(pw2)) {
				System.out.println("=================================");
				System.out.println("           회원가입 성공!           ");
				System.out.println("         즐거운 쇼핑 되세요!          ");
				System.out.println("=================================");
				break;
			} 
			else {
				System.out.println("=================================");
				System.out.println("      비밀번호가 일치하지 않습니다!     ");
				System.out.println("         다시 입력해 주세요!         ");
				System.out.println("=================================");
			}
		}
		return pw;
	}


	public void printLoginSuccess (String id){
		//로그인 성공!
		System.out.println("*********** 로그인 성공! ***********");
		System.out.println("=================================");
		System.out.println("          반갑습니다! " + id + "님!");
		System.out.println("       원하시는 상품을 담아보세요!      "); // 원하시는 상품을 담아보세요!
		System.out.println("=================================");
	}

	public void printLoginFail () {
		//로그인 실패!
		System.out.println("*********** 로그인 실패! ***********");
		System.out.println("=================================");
		System.out.println("         다시 로그인 해주세요!        "); // 원하시는 상품을 담아보세요!
		System.out.println("=================================");
	}
}