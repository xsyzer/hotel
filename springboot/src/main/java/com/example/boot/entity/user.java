package com.example.boot.entity;

import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class user {
	@NotNull(message="id不能为空")
	@JsonProperty(value="Id")
	private int Id;
	@NotNull(message="用户名不能为空")
	@JsonProperty(value="UserName")
    private String UserName;
	@NotNull(message="密码不能为空")
	@JsonProperty(value="UserPwd")
    private String UserPwd;
	@NotNull(message="姓名不能为空")
	@JsonProperty(value="Name")
    private String Name;
	@NotNull(message="地址不能为空")
	@JsonProperty(value="Address")
    private String Address;
	@NotNull(message="电话不能为空")
	@JsonProperty(value="PhoneNumber")
    private String PhoneNumber;
	@NotNull(message="性别不能为空")
	@JsonProperty(value="Sex")
    private String Sex;
    
	public user(int Id,String UserName ,String UserPwd, String Name,String Address, String PhoneNumber,String Sex) {
		super();
		this.Id=Id;
		this.UserName=UserName;
		this.UserPwd=UserPwd;
		this.Name=Name;
		this.Address=Address;
		this.PhoneNumber=PhoneNumber;
		this.Sex=Sex;
	}
	//getters和settters
	public int getId() {
		return Id;
	}
	public void setId(int Id) {
		this.Id = Id;
	}
	public String getUsername() {
		return UserName;
	}
	public void setUsername(String UserName) {
		this.UserName = UserName;
	}
	public String getUserpwd() {
		return UserPwd;
	}
	public void setUserpwd(String UserPwd) {
		this.UserPwd = UserPwd;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String Address) {
		this.Address = Address;
	}
	public String getPhonenumber() {
		return PhoneNumber;
	}
	public void setPhonenumber(String PhoneNumber) {
		this.PhoneNumber = PhoneNumber;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String Sex) {
		this.Sex = Sex;
	}
	public user() {
		super();
	}
	 @Override
	    public String toString() {
	        return "User [id="+Id+",username="+UserName+" userpwd="+UserPwd+", name="+Name+",address="+Address+",phonenumber="
	        	+PhoneNumber+",sex="+Sex+"]";
	    }
}
