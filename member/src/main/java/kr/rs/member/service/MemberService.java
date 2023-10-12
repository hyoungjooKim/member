package kr.rs.member.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.rs.member.component.MemberDTO;

public interface MemberService {
	public MemberDTO getUser(String userid);
	public List<MemberDTO> getUserList();
	public void insertUser(MemberDTO user);
	public void updateUser(MemberDTO user,String userid);
	public void deleteUser(String userid);
	public int checkUser(String userid);
}
