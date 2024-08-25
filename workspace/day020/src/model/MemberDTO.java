package model;

public class MemberDTO {
	private String Mid; // 아이디
	private String password; // 비밀번호

	public String getMid() {
		return Mid;
	}
	public void setMid(String mid) {
		this.Mid = mid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "MemberDTO [Mid=" + Mid + ", passward=" + password + "]";
	}
	

}