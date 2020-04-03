package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.dto.BooksInformation;
import com.capgemini.librarymanagementsystem.dto.UserInformation;
import com.capgemini.librarymanagementsystem.dto.UserRequestInformation;

public interface UserService {

	// boolean registration(UserInformation userInfo);
	UserInformation userLogin(String email, String password);

	BooksInformation searchBook(int bookId);

	UserRequestInformation borrowBook(UserInformation userInfo, BooksInformation bookInfo);

	UserRequestInformation returnBook(UserInformation userInfo, BooksInformation bookInfo);

}
