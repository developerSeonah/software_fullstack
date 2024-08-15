package view;

import java.util.ArrayList;
import java.util.Scanner;

import service.model.StudentDTO;

public class StudentView {
	static Scanner sc=new Scanner(System.in);

	// 출력 부분
	// 메뉴 출력
	public void printMenu() {
		System.out.println("=== 메 뉴 ===");
		System.out.println("1. 학생추가");
		System.out.println("2. 전체출력");
		System.out.println("3. 번호검색");
		System.out.println("4. 이름검색");
		System.out.println("5. 평균출력");
		System.out.println("6. 점수변경");
		System.out.println("7. 학생삭제");
		System.out.println("0. 프로그램 종료");
		System.out.println("==========");
	}
	// 이름 입력 안내 출력
	public void printNameInfo() {
		System.out.print("추가할 학생의 이름 입력 >> ");
	}
	// 성적 입력 안내 출력
	public void printScoreInfo() {
		System.out.print("추가할 학생의 성적 입력 >> ");
	}
	// 학생 추가 완료 멘트 출력
	public void printAddSuccess() {
		System.out.println("학생 추가 완료!");
	}
	// 전체 목록 출력
	public void printAllList(ArrayList<StudentDTO> datas) {
		System.out.println("=== 전체 목록 ===");
		for(StudentDTO data : datas) {
			System.out.println(data);
		}
		System.out.println("===============");
	}
	
	// 목록이 비어있을 때 출력
	public void printEmpty() {
		System.out.println("출력할 데이터가 없습니다!");
	}
	// 검색할 학생 번호 입력 안내 출력
	public void printNumInfo() {
		System.out.print("검색할 학생의 번호 입력 >> ");
	}
	// 검색 결과 출력
	public void printSearchList(StudentDTO data) {
		if(data==null) {
			System.out.println("검색 결과가 없습니다!");
			return;
		}
		System.out.println("=== 검색 결과 ===");
		System.out.println(data);
		System.out.println("===============");
	}
	// 검색 결과 여러명 출력
		public void printSearchList(ArrayList<StudentDTO> datas) {
			if(datas.size() == 0) {
				System.out.println("검색 결과가 없습니다!");
				return;
			}
			System.out.println("=== 검색 결과 ===");
			for(StudentDTO data : datas) {
				System.out.println(data);
			}
			System.out.println("===============");
		}
	// 삭제할 이름 입력 출력
	public void printDeleteInfo() {
		System.out.println("삭제할 학생의 학번 입력 >> ");
	}
	// 삭제 성공, 실패 출력
	public void printIsDelete(boolean result) {
		if(result) {
			System.out.println("삭제 성공!");	
			return;
		}
		System.out.println("삭제 실패..");
	}
	// 점수 업데이트 성공 출력
	public void printIsUpdate(boolean result) {
		if(result) {
			System.out.println("점수 업데이트 성공!");	
			return;
		}
		System.out.println("점수 업데이트 실패..");
	}
	// 평균 출력
	public void printAvg(double avg) {
		System.out.println("평균은 " + avg + "입니다.");
	}
	// 이름 검색 출력
	public void printNameSearchInfo() {
		System.out.println("검색할 이름을 입력 >> ");
	}
	

	// 입력 부분
	// 메뉴 입력
	public int inputAction() {
		int action=sc.nextInt();
		return action;
	}
	// 이름 입력
	public String inputName() {
		String name;
		while(true){
			name=sc.next();

			System.out.println("정말 " + name +"으로 입력하시겠습니까? (Y/N)");
			String answer = sc.next();

			if(answer.equals("Y")) {
				break;
			}
			this.printNameInfo();
		}
		return name;
	}
	// 점수 입력
	public int inputScore() {
		int score=sc.nextInt();
		return score;
	}
	// 번호 입력
	public int inputNum(int lastPK) {
		int num;
		while(true) {
			num=sc.nextInt();
			if(101 <= num && num <= lastPK) {
				break;
			}
			System.out.println("다시 입력해주세요.");
		}
		return num;
	}
}
