package com.capgemini.librarymanagementsystem.dto;

import java.io.Serializable;
import java.util.Date;

public class UserRequestInformation implements Serializable {

	private BooksInformation bookInfo;
	private UserInformation userInfo;
	private Date dateOfIssued;
	private Date dateOfReturn;
	private boolean bookIssued;
	private boolean bookReturned;

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
