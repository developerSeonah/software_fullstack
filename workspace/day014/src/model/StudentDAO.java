package model;

import java.util.ArrayList;

// MVC 패턴에서 DBMS 파트를 DAO라고 함
// 매니지먼트 시스템
public class StudentDAO {
	// 멤버 변수
	private ArrayList<StudentDTO> datas;
	private String condition;	// 개발자용 변수

	// 생성자
	// 미리 3명의 학생을 만들어 놓음
	public StudentDAO() {
		System.out.println("   service.model.StudentDAO StudentDAO() 생성자 시작");
		// 학생 객체를 담을 새로운 datas 배열을 만듦
		datas = new ArrayList<StudentDTO>();

		// 샘플 데이터 or 기존 데이터 생성
		// 학생 객체1을 만듦
		StudentDTO data1=new StudentDTO();
		data1.setNum(101);
		data1.setName("오리아나");
		data1.setScore(50);
		// 생성된 학생1을 datas 배열에 넣어줌
		datas.add(data1);

		// 학생2
		StudentDTO data2=new StudentDTO();
		data2.setNum(102);
		data2.setName("모르가나");
		data2.setScore(89);
		datas.add(data2);

		// 학생3
		StudentDTO data3=new StudentDTO();
		data3.setNum(103);
		data3.setName("티모");
		data3.setScore(67);
		datas.add(data3);
		System.out.println("   service.model.StudentDAO  StudentDAO() 생성자 종료");
	}


	// 함수
	// CRUD에 의하여 함수 5개만 생성 가능
	public boolean insert(StudentDTO studentdto) {
		System.out.println("   service.model.StudentDAO insert() 생성자 시작");
		// DBMS에 data를 추가 == AL에 DTO 추가
		// 객체를 생성, 멤버변수 값들을 넣어줌
		StudentDTO data = new StudentDTO();
		
		data.setNum(studentdto.getNum());
		data.setName(studentdto.getName());
		data.setScore(studentdto.getScore());
		// 데이터를 넣어줌 학생부 목록에 넣어줌
		datas.add(data);
		System.out.println("   service.model.StudentDAO insert() 생성자 종료");
		return true;
	}
	public boolean update(StudentDTO studentdto) {
		// 점수를 변경함
		if(studentdto.getCondition().equals("SCORE")) {
			// 학번을 받아옴
			// 배열은 현재 배열을 사용
			// 해당 학번의 학생을 찾아봄
			System.out.println("   service.model.StudentDAO update() 생성자 시작");
			for(int i = 0 ; i < datas.size(); i++) {
				if(datas.get(i).getNum() == studentdto.getNum()) {
					datas.get(i).setScore(studentdto.getScore());
					System.out.println("   service.model.StudentDAO update() 성공");
					return true;
				}
			}
		}
		
		System.out.println("   service.model.StudentDAO update() 실패");
		return false;
	}
	
	public boolean delete(StudentDTO studentdto) {
		System.out.println("   service.model.StudentDAO delete() 생성자 시작");
		// 삭제하려는 학번을 받아옴
		// 배열은 현재 배열을 사용 
		// 해당 학번의 학생을 찾아봄
		for(int i = 0 ; i < datas.size(); i++) {
			if(datas.get(i).getNum() != studentdto.getNum()) {
				continue;
			}
			datas.remove(i);
			System.out.println("   service.model.StudentDAO delete() 성공");
			return true;
		}
		System.out.println("   service.model.StudentDAO delete() 실패");
		return false;
	}
	
	// 전체 출력
	public ArrayList<StudentDTO> selectAll(StudentDTO studentdto){
		System.out.println("   service.model.StudentDAO selectAll() 시작");
		ArrayList<StudentDTO> datas = new ArrayList<StudentDTO>();
		
		// 전체 출력
		if(studentdto.getCondition().equals("ALL")) {
			for(StudentDTO data : this.datas) {
				datas.add(data);
			}
		}
		
		// 이름 검색
		if(studentdto.getCondition().equals("NAME")) {
			for(StudentDTO data : this.datas) {
				if(data.getName().contains(studentdto.getName())) {
					datas.add(data);
				}
			}
		}
		
		// 데이터 전체 목록을 넘기면 됨
		System.out.println("   service.model.StudentDAO selectAll()");
		return datas;
	}
	
	// 한 명만 출력
	// 학번을 인자로 받음
	public StudentDTO selectOne(StudentDTO studentdto){
		System.out.println("   service.model.StudentDAO selectOne() 생성자 시작");
		// datas(학생부) 전체를 확인하여 일치하는 학번이 있는지 검사 
		for(StudentDTO data : this.datas) {
			// 만약 일치한다면
			if(data.getNum() == studentdto.getNum()) {
				System.out.println("   service.model.StudentDAO selectOne() 데이터 일치");
				// 일치하는 데이터를 반환
				return data;
			}
		}
		System.out.println("   service.model.StudentDAO selectOne() 데이터 불일치");
		// 없다면 공백을 반환
		return null;
	}
}