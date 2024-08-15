package model;

import java.util.ArrayList;

public class MemberDAO {
	private ArrayList<MemberDTO> datas;
	
	// 생성자
	public MemberDAO() {
		this.datas = new ArrayList<MemberDTO>();

		// 샘플 데이터 생성
		MemberDTO data=new MemberDTO();
		data.setMid("teemo");
		data.setPassword("1234");
		data.setName("작은티모");
		this.datas.add(data);
	}

	public boolean insert(MemberDTO memberDTO) {
		// 회원가입
		System.out.println("   MemberDAO.insert()  시작");
		// C를 신뢰 x
		// PK 값을 중복 확인
		// member 원본 데이터를 가져와서 중복 확인
		for(MemberDTO mdata : this.datas) {
			// 중복되는 id가 있다면
			if(mdata.getMid().equals(memberDTO.getMid())) {
				// id 생성 실패
				System.out.println("   MemberDAO.insert()  실패");
				return false;
			}
		}
		
		// id 생성
		// 새로운 MemberDTO 객체 생성
		MemberDTO data = new MemberDTO();
		
		// 인자에서 값을 받아서 새 객체(data)에 넣어줌
		data.setMid(memberDTO.getMid());
		data.setName(memberDTO.getName());
		data.setPassword(memberDTO.getPassword());
		
		// data를 datas에 추가
		datas.add(data);
		
		// 성공(true) 반환
		System.out.println("   MemberDAO.insert()  성공");
		return true;	
	}
	// 아직 기능 개발x
	private boolean update(MemberDTO memberDTO) {
		return false;
	}
	public boolean delete(MemberDTO memberDTO) {
		// 회원탈퇴
		System.out.println("   MemberDAO.delete()  시작");
		
		// 데이터 확인, 찾는 작업
		// 원본 데이터들을 가져와서 값을 하나씩 부름 (for)
		for(int i = 0; i < this.datas.size(); i++) {
			// 만약 data가 인자의 id 데이터와 같다면
			if(datas.get(i).getMid().equals(memberDTO.getMid())) {
				// 해당 데이터 삭제
				datas.remove(i);
				// 삭제 성공
				System.out.println("   MemberDAO.delete()  성공");
				return true;
			}
		}
		
		// 삭제 실패
		System.out.println("   MemberDAO.delete()  실패");
		return false;
	}
	// 아직 기능 개발x
	private ArrayList<MemberDTO> selectAll(MemberDTO memberDTO){
		ArrayList<MemberDTO> datas = new ArrayList<MemberDTO>();
		return datas;
	}
	
	public MemberDTO selectOne(MemberDTO memberDTO) {
		// 로그인 (아이디로 검색)
		System.out.println("   MemberDAO.selectOne()  시작");
		// 데이터 확인, 찾는 작업
		// 원본 데이터를 가져와서 값을 하나씩 부름 (for each)
		for(MemberDTO data : this.datas) {
			// if 불러온 데이터의 id 값이 인자의 id값과 같다면
			if(data.getMid().equals(memberDTO.getMid())
					&& data.getPassword().equals(memberDTO.getPassword())) {
				// 해당 data 반환
				System.out.println("   MemberDAO.selectOne()  성공");
				return data;
			}
		}

		// 찾지 못했을 시
		System.out.println("   MemberDAO.selectOne()  null");
		return null;
	}
}
