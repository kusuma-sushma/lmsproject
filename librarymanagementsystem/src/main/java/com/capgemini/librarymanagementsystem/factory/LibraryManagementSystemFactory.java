package com.capgemini.librarymanagementsystem.factory;

import java.util.Date;

import com.capgemini.librarymanagementsystem.dao.AdminDao;
import com.capgemini.librarymanagementsystem.dao.AdminDaoImplementation;
import com.capgemini.librarymanagementsystem.dao.UserDao;
import com.capgemini.librarymanagementsystem.dao.UserDaoImplementation;
import com.capgemini.librarymanagementsystem.dto.AdminInformation;
import com.capgemini.librarymanagementsystem.dto.BooksInformation;
import com.capgemini.librarymanagementsystem.dto.UserInformation;
import com.capgemini.librarymanagementsystem.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystem.service.AdminService;
import com.capgemini.librarymanagementsystem.service.AdminServiceImplementation;
import com.capgemini.librarymanagementsystem.service.UserService;
import com.capgemini.librarymanagementsystem.service.UserServiceImplementation;
import com.capgemini.librarymanagementsystem.validation.LibraryManagementSystemValidation;

public class LibraryManagementSystemFactory {

	private LibraryManagementSystemFactory() {

	}

	public static UserDao getUserDao() {
		return new UserDaoImplementation();
	}

	public static UserService getUserService() {
		return new UserServiceImplementation();

	}

	public static AdminDao getAdminDao() {
		return new AdminDaoImplementation();
	}

	public static AdminService getAdminService() {
		return new AdminServiceImplementation();
	}

	public static AdminInformation getAdminInfo() {
		return new AdminInformation();
	}

	public static BooksInformation getBookInfo() {
		return new BooksInformation();
	}

	public static UserInformation getUserInfo() {
		return new UserInformation();
	}

	public static LibraryManagementSystemValidation getValidation() {
		return new LibraryManagementSystemValidation();
	}

	public static UserRequestInformation userRequest() {
		return new UserRequestInformation();
	}

	public static Date getDate() {
		return new Date();
	}
}
