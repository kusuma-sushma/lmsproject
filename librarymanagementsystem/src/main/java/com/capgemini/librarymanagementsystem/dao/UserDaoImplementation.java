package com.capgemini.librarymanagementsystem.dao;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.database.LibraryManagementSystemDataBase;
import com.capgemini.librarymanagementsystem.dto.BooksInformation;
import com.capgemini.librarymanagementsystem.dto.UserInformation;
import com.capgemini.librarymanagementsystem.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementSystemException;
import com.capgemini.librarymanagementsystem.factory.LibraryManagementSystemFactory;

public class UserDaoImplementation implements UserDao{

	@Override
	public UserInformation userLogin(String email, String password) {
			for(UserInformation info:LibraryManagementSystemDataBase.user) {
			if(info.getEmail().equals(email) && info.getPassword().equals(password)) {
					return info;
				}
			}
			throw new LibraryManagementSystemException("invalid user details");
			}
		

	@Override
	public BooksInformation searchBook(int bookId) {
		for(BooksInformation booksinfo:LibraryManagementSystemDataBase.book) {
			if(booksinfo.getBookId()==bookId) 
			return booksinfo;
		
		}
		throw new LibraryManagementSystemException("searched book is not available");

	}

	@Override
	public List<BooksInformation> showAllBooks() {
		List<BooksInformation> booksList = new LinkedList<BooksInformation>();
		
		for (BooksInformation bookInfo : LibraryManagementSystemDataBase.book) {
			bookInfo.getBookId();
			bookInfo.getBookName();
			bookInfo.getBookAuthor();
			bookInfo.getBookCategory();
			bookInfo.getBookPublisher();
			booksList.add(bookInfo);
		}
		return booksList;
	}
	@Override
	public UserRequestInformation borrowBook(UserInformation userInfo, BooksInformation bookInfo) {
		boolean request = false; 
		boolean requestBook = false;
		UserRequestInformation requestInfo = LibraryManagementSystemFactory.userRequest();
		for (UserRequestInformation requestInfo2 : LibraryManagementSystemDataBase.requests) {
			if (bookInfo.getBookId() == requestInfo2.getBookInfo().getBookId()) {
				requestBook = true;

			}

		}

		if (!requestBook) {
					for (BooksInformation book : LibraryManagementSystemDataBase.book) {
						if (bookInfo.getBookId() == book.getBookId()) {
							bookInfo = book;
							request = true;
				}
			}
			if (request == true) {
				requestInfo.setBookInfo(bookInfo);
				LibraryManagementSystemDataBase.requests.add(requestInfo);
				return requestInfo;
			}
		}
		throw new LibraryManagementSystemException("Invalid user or book credentials book can not be borrowed");
	}

	@Override
	public UserRequestInformation returnBook(UserInformation userInfo, BooksInformation bookInfo) {
		for (UserRequestInformation requestInfo : LibraryManagementSystemDataBase.requests) {
			
			  if (requestInfo.getBookInfo().getBookId() == bookInfo.getBookId() &&
			  requestInfo.getUserInfo().getUserId() == userInfo.getUserId() &&
			  requestInfo.isBookIssued() == true) {
			 
			if (requestInfo.isBookIssued() == true) {
				System.out.println("Returning Issued book only");
				requestInfo.setBookReturned(true);
				return requestInfo;
			}
		}
		throw new LibraryManagementSystemException("Invalid user or book credentials book can not be returned");
	}
		return null;
}
}

