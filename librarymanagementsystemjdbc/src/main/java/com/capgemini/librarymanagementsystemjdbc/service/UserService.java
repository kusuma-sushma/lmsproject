package com.capgemini.librarymanagementsystemjdbc.service;

import com.capgemini.librarymanagementsystemjdbc.dto.BooksInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.UserInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.UserRequestInformation;


public interface UserService {
	
	//boolean registration(UserInformation userInfo);
	UserInformation userLogin(String email, String password);
	BooksInformation searchBook(int bookId);
	UserRequestInformation borrowBook(UserInformation userInfo, BooksInformation bookInfo);
	UserRequestInformation returnBook(UserInformation userInfo, BooksInformation bookInfo);
	

}
