package com.capgemini.librarymanagementsystemjdbc.dao;

import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.AdminInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.BooksInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.UserInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.UserRequestInformation;



public interface AdminDao {

	AdminInformation adminLogin(String email, String password);
	boolean addUser(UserInformation userInfo);
	boolean addBook(BooksInformation bookInfo);
	boolean removeBook(int bookId);
	//boolean returnedBook(int bookId);
	boolean issueBook(UserInformation userInfo, BooksInformation bookInfo);
	BooksInformation updateBook(int bookId);
	BooksInformation searchBook(int bookId);
	List<BooksInformation> showAllBooks(); 
	List<UserInformation> showAllUsers();
	List<UserRequestInformation> showAllRequests();
	boolean isBookRecevied(UserInformation userInfo, BooksInformation bookInfo);

}
