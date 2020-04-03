package com.capgemini.librarymanagementsystemjdbc.dao;

import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.BooksInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.UserInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.UserRequestInformation;


public interface UserDao {

	//boolean registration(UserInformation info,int count);
	UserInformation userLogin(String email, String password);
	List<BooksInformation> showAllBooks();
	BooksInformation searchBook(int bookId);
	UserRequestInformation borrowBook(UserInformation userInfo, BooksInformation bookInfo);
	UserRequestInformation returnBook(UserInformation userInfo, BooksInformation bookInfo);

}
