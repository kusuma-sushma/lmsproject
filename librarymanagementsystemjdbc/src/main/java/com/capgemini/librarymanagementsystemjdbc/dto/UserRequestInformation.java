package com.capgemini.librarymanagementsystemjdbc.dto;

import java.io.Serializable;
import java.util.Date;

public class UserRequestInformation implements Serializable{

	private BooksInformation bookInfo;
	private UserInformation userInfo;
	private Date dateOfIssued;
	private Date dateOfReturn;
	private boolean bookIssued;
	private boolean bookReturned;
	private String status;
	private int bookId;
	private String bookName;
	private int userId;
	private String username;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStatus() {
		return status;
	}
	public String setStatus(String status) {
		return this.status = status;
	}
	public BooksInformation getBookInfo() {
		return bookInfo;
	}
	public UserInformation getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInformation userInfo) {
		this.userInfo = userInfo;
	}
	public void setBookInfo(BooksInformation bookInfo) {
		this.bookInfo = bookInfo;
	}
	public Date getDateOfIssued() {
		return dateOfIssued;
	}
	public void setDateOfIssued(Date dateOfIssued) {
		this.dateOfIssued = dateOfIssued;
	}
	public Date getDateOfReturn() {
		return dateOfReturn;
	}
	public void setDateOfReturn(Date dateOfReturn) {
		this.dateOfReturn = dateOfReturn;
	}
	public boolean isBookIssued() {
		return bookIssued;
	}
	public void setBookIssued(boolean bookIssued) {
		this.bookIssued = bookIssued;
	}
	public boolean isBookReturned() {
		return bookReturned;
	}
	public void setBookReturned(boolean bookReturned) {
		this.bookReturned = bookReturned;
	}
	
	
}
