package kr.rs.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.rs.member.component.MemberDTO;

public interface MemberMapper {
	public MemberDTO getUser(String userid);
	public List<MemberDTO> getUserList();
	public void insertUser(MemberDTO user);
	public void updateUser(@Param("user") MemberDTO user, @Param("userid") String userid);
	public void deleteUser(String userid);
	public int checkUser(String userid);
}
