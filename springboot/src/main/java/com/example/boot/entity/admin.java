package com.example.boot.entity;

public class admin {
	private int Id;



	private int Num;

	public admin(int num) {
		Num = num;
	}

	private String AdminName;
	private String AdminPwd;
	
	public admin(int Id,int Num,String AdminName ,String AdminPwd) {
		super();
		this.Id=Id;
		this.Num=Num;
		this.AdminName=AdminName;
		this.AdminPwd=AdminPwd;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getNum() {
		return Num;
	}

	public void setNum(int num) {
		Num = num;
	}
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String adminName) {
		AdminName = adminName;
	}
	public String getAdminPwd() {
		return AdminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		AdminPwd = adminPwd;
	}
}
