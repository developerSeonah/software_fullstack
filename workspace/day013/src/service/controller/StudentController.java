package service.controller;

import java.util.ArrayList;

import service.model.StudentDTO;
import service.model.StudentDAO;
import view.StudentView;

public class StudentController {
	// 멤버변수
	private StudentDAO model;	// 학생부
	private StudentView view;	// 출력할 것들 목록
	private int PK; 			// 학번을 넣어줄 정수 변수

	// 생성자
	public StudentController() {
		this.model=new StudentDAO();
		this.view=new StudentView();
		this.PK=104;		// 샘플 데이터가 이미 3명이 있기 때문에 104번부터 선택
	}

	// 사용자(Client)에게 [M과 V를 조합해서] 서비스를 제공하는 역할
	public void start() {
		while (true) {
			// 메뉴 출력
			view.printMenu();
			// 메뉴 선택값을 반환받음
			int action=view.inputAction();

			if(action == 1) {		// 학생 추가
				view.printNameInfo();				// 이름을 입력받으라는 멘트
				String name=view.inputName();		// 입력을 받음
				view.printScoreInfo();				// 점수를 입력받으라는 멘트
				int score=view.inputScore();		// 점수를 입력받음

				// 값을 입력받고 제대로 입력받았는지 확인하는 값을 반환
				boolean flag=model.insert(PK++, name, score);
				if(flag) {	// 만약 성공했다면
					view.printAddSuccess();	// 성공 멘트
				}	
				else {
					// 실패했습니다.
					System.out.println("실패했습니다.");
				}
			}
			else if(action == 2){	// 전체 출력
				// 학생부에 있는 데이터를 전부 반환받아(selectAll) 새로운 배열 datas에 넣어줌
				// <StudentDTO>은 배열 타입
				ArrayList<StudentDTO> datas=model.selectAll();
				view.printAllList(datas);	// 전부 출력
			}
			else if(action == 3){	// 번호 검색
				view.printNumInfo();		// 번호를 입력하라는 멘트
				int num = view.inputNum(PK);	// 번호를 입력받음

				// 입력받은 번호를 인자로 검색(출력) 실행
				// view에서 출력
				// DAO에서 인자를 받아 값을 반환
				view.printSearchList(model.selectOne(num));
			}
			else if(action == 4){	// 이름 겁색
				// 이름 입력 안내 (view)
				view.printNameSearchInfo();
				// 이름 입력 받음, 입력값 확인 (view)
				String name = view.inputName();

				// 입력값이 포함된 이름이 있나 확인 (model)
				ArrayList<StudentDTO> al = model.selectAll(name);
				// 출력(view)
				view.printAllList(al);
			}
			else if(action == 5){	// 평균 출력
				// 평균을 받아옴 (model)
				double avg = model.avg();
				// 평균값 출력 (view)
				view.printAvg(avg);
			}
			else if(action == 6){	// 점수 변경
				// 학번을 입력하라는 안내(view)
				view.printNumInfo();
				// 학번을 입력받음(view)
				int num = view.inputNum(PK);

				// 변경할 점수 입력 안내(view)
				view.printScoreInfo();
				// 변경할 점수를 입력받음(view)
				int score = view.inputScore();

				// 학번에 맞는 학생을 찾아서 점수 변경 (model)
				model.update(num, score);
			}
			else if(action == 7){	// 학생 삭제
				// 학번을 입력하라는 안내
				view.printDeleteInfo();
				// 학번을 입력받음
				int num = view.inputNum(PK);

				// 학생을 찾아서 삭제 시도
				boolean flag = model.delete(num);

				// 삭제 성공 실패 출력(view)
				view.printIsDelete(flag);
			}
			else if(action == 0){
				break;
			}

		}
	}
}
