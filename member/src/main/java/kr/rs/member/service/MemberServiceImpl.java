package kr.rs.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.rs.member.component.MemberDTO;
import kr.rs.member.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper mapper;
	
	public MemberDTO getUser(String userid) {
		return mapper.getUser(userid);
	}
	
	public List<MemberDTO> getUserList(){
		return mapper.getUserList();
	}
	
	public void insertUser(MemberDTO user) {
		mapper.insertUser(user);
	}
	
	public void updateUser(MemberDTO user,String userid) {
		mapper.updateUser(user, userid);
	}
	
	public void deleteUser(String userid) {
		mapper.deleteUser(userid);
	}
	
	public int checkUser(String userid) {
		return mapper.checkUser(userid);
	}
}
