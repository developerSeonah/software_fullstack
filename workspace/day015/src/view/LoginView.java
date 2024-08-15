package view;

import java.util.ArrayList;

import model.BoardDTO;

public class LoginView extends View {
	// 로그아웃
	// 글 작성
	// 글 삭제
	// 글 내용 변경
	// 회원탈퇴

	// 메뉴 출력
	public void printMenu() {
		System.out.println("7. 로그아웃");
		System.out.println("8. 글 작성");
		System.out.println("9. 글 삭제");
		System.out.println("10. 글 내용 변경");
		System.out.println("11. 회원탈퇴");
	}

	// 글 작성
	public BoardDTO inputBoardData() {
		System.out.print("제목 입력 >> ");
		String title = sc.next();
		System.out.print("내용 입력 >> ");
		String content = sc.next();

		BoardDTO data = new BoardDTO();
		data.setTitle(title);
		data.setContent(content);

		return data;
	}

	// 글 삭제
	public int inputDeleteNum(ArrayList<BoardDTO> datas) {
		// 삭제할 글 번호를 입력하라고 출력하고, 입력받기
		int num;
		for(BoardDTO data : datas) {
			System.out.println(data);
		}
		
		while(true) {
			System.out.print("삭제할 글 번호 입력 >> ");
			num = sc.nextInt();

			// 유효성 검사
			// 배열 리스트가 가지고있는 가장 낮은 숫자부터 가장 높은 숫자까지의 숫자 중에서 고름
			// 배열 안의 숫자는 오름차순이므로
			if(datas.get(0).getNum()<= num && num <= datas.get(datas.size()-1).getNum()) {
				break;
			}
			System.out.println("다시 입력해주세요.");
		}
		// 글 번호 반환
		return num;
	}
	
	// 회원탈퇴 확인작업
	public boolean isDelete() {
		System.out.print("정말 삭제하시겠습니까? (Y/N) >> ");
		String answer = sc.next();
		
		if (answer.equals("Y")) {
			return true;
		}
		
		System.out.println("탈퇴가 취소되었습니다.");
		return false;
	}
}
