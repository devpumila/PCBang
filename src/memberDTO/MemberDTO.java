package memberDTO;

import java.util.ArrayList;

import memberDAO.MemberDAO;

public class MemberDTO {
	private String id, pw, name, phonenumber, email;
	private int time, seat;
	private int postPayment = 0;
	private boolean isMember = false;

	private int nonidcheck;

	public int getNonidcheck() {
		return nonidcheck;
	}

	public void setNonidcheck(int nonidcheck) {
		this.nonidcheck = nonidcheck;
	}

	public static MemberDTO getMemberDTO(String id, boolean isMember) {// 기존에 ID가 있으면
		MemberDTO memberDTO = null;
		MemberDAO dao = MemberDAO.getInstance();

		if (isMember) {
			ArrayList<MemberDTO> memberlist = dao.getUserList();
			for (MemberDTO list : memberlist) {
				if (list.getId().equals(id))
					memberDTO = list;
			}
		} else
			memberDTO = dao.getNonMemInfo(id);
		return memberDTO;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPostPayment(int postPayment) {
		this.postPayment = postPayment;
	}

	public int getPostPayment() {
		return postPayment;
	}

	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		String text = "[" + seat + "]번  [" + name + "] 님 (ID : " + id + ")";
		return text;
	}
}