package com.example.boot.entity;

public class dishes {
	private String name;
	private String price;
	private String star;
	private int adminid;
	private int id;
	private int num;
	private int score;
	public dishes(String name,String price,String star,int adminid,int id,int num,int score) {
		this.name=name;
		this.price=price;
		this.star=star;
		this.adminid=adminid;
		this.id=id;
		this.num=num;
		this.score=score;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
