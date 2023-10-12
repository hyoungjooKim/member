package kr.rs.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.rs.member.component.MemberDTO;
import kr.rs.member.service.MemberService;

@RestController
public class MemberController {
	@Autowired
	private MemberService Service;
	
	// Search from {userid}'s information
	// @RequestMapping("/users/{userid}")
	@RequestMapping(value = "/users/{userid}", produces = "application/json; charset=utf-8")
	public MemberDTO getUser(@PathVariable String userid) {
		MemberDTO user = Service.getUser(userid);
		System.out.println(userid+"의 정보 확인");
		return user;
	}
	
	// Search from All user's information
	// @GetMapping("/users")
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public List<MemberDTO> allUser(){
		List<MemberDTO> userList = Service.getUserList();
		System.out.println("전체 테이터베이스 정보 확인");
		return userList;
	}
	
	// Insert information into Oracle DB
	// @PostMapping("/users")
	@RequestMapping(value = "/users", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String insert(@RequestBody MemberDTO user) {
		String result = "";
		
		if(user != null) {
			System.out.println("신규 유저 추가");
			System.out.println(user.toString());
			
			Service.insertUser(user);
			result = "생성 완료";
			return result;
		}else {
			result = "생성 미완료";
			return result;
		}
	}
	
	// modify information where {userid} is exist
	// @PatchMapping("/users/{userid}")
	@RequestMapping(value = "/users/{userid}", method = RequestMethod.PATCH, produces = "application/json; charset=utf-8")
	public String update(@RequestBody MemberDTO user,@PathVariable String userid) {
		String result = "";
		int usercheck = Service.checkUser(userid);
		if(usercheck == 1) {
			System.out.println(userid+"의 정보 수정");
			Service.updateUser(user, userid);
			result = "수정 완료";
			return result;
		}else {
			result = "생성 미완료 - 계정 정보가 없습니다.";
			return result;
		}
	}
	
	// Delete information where {userid} is exist
	// @DeleteMapping("/users/{userid}")
	@RequestMapping(value = "/users/{userid}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
	public String delete(@PathVariable String userid) {
		String result = "";
		int usercheck = Service.checkUser(userid);
		if(usercheck == 1) {
			System.out.println(userid+"의 정보 삭제");
			Service.deleteUser(userid);
			result = "삭제 완료";
			return result;
		}else {
			result = "삭제 미완료 - 계정 정보가 없습니다.";
			return result;
		}
	}
}
