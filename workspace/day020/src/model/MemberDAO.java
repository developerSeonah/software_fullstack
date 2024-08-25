package model;


import java.util.ArrayList;

public class MemberDAO {
	private ArrayList<MemberDTO> datas;

	public MemberDAO(){
		this.datas = new ArrayList<MemberDTO>();

		MemberDTO data = new MemberDTO(); //샘플데이터 1
		data.setMid("teemo");
		data.setPassword("1234");
		this.datas.add(data);

		MemberDTO data1 = new MemberDTO(); //샘플데이터 2
		data1.setMid("ari");
		data1.setPassword("ari123");
		this.datas.add(data);

		MemberDTO data2 = new MemberDTO(); //샘플데이터3
		data2.setMid("아무말");
		data2.setPassword("아무번호");
		this.datas.add(data2);
	}


	public boolean  insert(MemberDTO memberDTO) {
		//회원가입
		System.out.println("model.MemberDAO.insert 실행 시작");

		//입력받은값을 사용자DB 추가

		MemberDTO data = new MemberDTO();
		//data에 input으로 받은 이름을 추가해줘
		data.setMid(memberDTO.getMid());
		
		//data에 input으로 받은 비밀번호 추가해줘
		data.setPassword(memberDTO.getPassword());
		
		//내 datas배열에 입력 다 받은 data 추가해줘
		this.datas.add(data);

		System.out.println("model.MemberDAO.insert 실행 끝");
		return true;
	}

	private ArrayList<MemberDTO> selectAll(MemberDTO memberDTO){
		//기능 미구현으로 hiding
		return datas;
	}

	public MemberDTO selectOne(MemberDTO memberDTO){
		System.out.println("model.MemberDAO.selectOne 시작");
		MemberDTO data = new MemberDTO(); // seletOne 저장공간 할당
		for(MemberDTO serch : this.datas) {
			if(serch.getMid().equals(memberDTO.getMid())) {
				data.setMid(serch.getMid());
				data.setPassword(serch.getPassword());
				System.out.println("model.MemberDAO.selectOne 완료");
				return data;
			}
		}
		System.out.println("model.MemberDAO.selectOne 중복없음");
		return null;
	}

	private boolean update(MemberDTO memberDTO) {
		//기능 미구현으로 hiding
		return false;
	}

	private boolean delete(MemberDTO memberDTO) {
		//기능 미구현으로 hiding
		return false;
	}
}