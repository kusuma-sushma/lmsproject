package com.capgemini.librarymanagementsystemjdbc.service;

import com.capgemini.librarymanagementsystemjdbc.dao.UserDao;
import com.capgemini.librarymanagementsystemjdbc.dto.BooksInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.UserInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystemjdbc.factory.LibraryManagementSystemFactory;


public class UserServiceImplementation implements UserService{

	private UserDao userDao=LibraryManagementSystemFactory.getUserDao();

//	@Override
//	public boolean registration(UserInformation userInfo) {
//		return userDao.registration(userInfo);
//	}

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
