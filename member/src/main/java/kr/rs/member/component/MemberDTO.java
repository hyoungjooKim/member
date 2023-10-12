package kr.rs.member.component;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MemberDTO {
	
	private String id;
	private String pw;
	private String name;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss a", timezone = "Asia/Seoul")
	private Date reg;
	
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", reg=" + reg + "]";
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
	public Date getReg() {
		return reg;
	}
	public void setReg(Date reg) {
		this.reg = reg;
	}
}
