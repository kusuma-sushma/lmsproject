package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.dto.AdminInformation;
import com.capgemini.librarymanagementsystem.dto.BooksInformation;
import com.capgemini.librarymanagementsystem.dto.UserInformation;
import com.capgemini.librarymanagementsystem.dto.UserRequestInformation;

public interface AdminService {

	boolean addUser(UserInformation userInfo);

	public AdminInformation adminLogin(String email, String password);

	public boolean addBook(BooksInformation info);

	public boolean removeBook(int bookId);

	// boolean returnedBook(int bookId);
	boolean issueBook(UserInformation userInfo, BooksInformation bookInfo);

	BooksInformation updateBook(int bookId);

	BooksInformation searchBook(int bookId);

	List<BooksInformation> showAllBooks();

	List<UserRequestInformation> showAllRequests();

	List<UserInformation> showAllUsers();

	boolean isBookRecevied(UserInformation userInfo, BooksInformation bookInfo);

}
