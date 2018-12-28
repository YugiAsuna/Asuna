package com.asuna.bean;
public class Book {//bName,writer,press,presstime,price,pageNum,sort,barCode,LendNum,state
	
	private String barCode;//图书属性变量： 条形码，作者，书名，出版社，出版时间，价格，借阅状态， 
	private String writer; //图书类别,页数，借阅次数
	private String bName;
	private String press; 
	private String presstime; 
	private double price;	
	private String state;
	private String sort;
	private int pageNum;
	private int LendNum;
//	private String borrower;
//	private int booknum;
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getPresstime() {
		return presstime;
	}
	public void setPresstime(String presstime) {
		this.presstime = presstime;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getLendNum() {
		return LendNum;
	}
	public void setLendNum(int lendNum) {
		LendNum = lendNum;
	}
	@Override
	public String toString() {
		return "Book [barCode=" + barCode + ", writer=" + writer + ", bName=" + bName + ", press=" + press
				+ ", presstime=" + presstime + ", price=" + price + ", state=" + state + ", sort=" + sort + ", pageNum="
				+ pageNum + ", LendNum=" + LendNum + "]";
	}

	
}
