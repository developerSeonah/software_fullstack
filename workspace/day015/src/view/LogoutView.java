package view;

import model.MemberDTO;

public class LogoutView extends View{
	// 회원가입
	// 로그인

	// 메뉴 출력
	public void printMenu() {
		System.out.println("5. 로그인");
		System.out.println("6. 회원가입");
	}
	
	// 로그인 진행 출력
	// id, password 두 가지를 반환하므로 객체(MemberDTO)로 반환
	public MemberDTO inputLoginInfo() {
		// id를 입력 안내문 출력, 입력받음
		System.out.print("아이디 입력 >> ");
		String mid = sc.next();
		// password를 입력 안내문 출력, 입력받음
		System.out.print("비밀번호 입력 >> ");
		String password = sc.next();
		
		// id와 password를 담을 새 객체 생성
		MemberDTO data = new MemberDTO();
		// 입력받은 값들 넣기
		data.setMid(mid);
		data.setPassword(password);
		
		// 반환
		return data;
	}
}
