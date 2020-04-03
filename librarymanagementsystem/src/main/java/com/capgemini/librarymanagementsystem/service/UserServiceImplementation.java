package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.dao.UserDao;
import com.capgemini.librarymanagementsystem.dto.BooksInformation;
import com.capgemini.librarymanagementsystem.dto.UserInformation;
import com.capgemini.librarymanagementsystem.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystem.factory.LibraryManagementSystemFactory;

public class UserServiceImplementation implements UserService {

	private UserDao userDao = LibraryManagementSystemFactory.getUserDao();

	@Override
	public UserInformation userLogin(String email, String password) {
		return userDao.userLogin(email, password);
	}

	@Override
	public BooksInformation searchBook(int bookId) {
		return userDao.searchBook(bookId);
	}

	@Override
	public UserRequestInformation borrowBook(UserInformation userInfo, BooksInformation bookInfo) {
		return userDao.borrowBook(userInfo, bookInfo);
	}

	@Override
	public UserRequestInformation returnBook(UserInformation userInfo, BooksInformation bookInfo) {
		return userDao.returnBook(userInfo, bookInfo);
	}

}
