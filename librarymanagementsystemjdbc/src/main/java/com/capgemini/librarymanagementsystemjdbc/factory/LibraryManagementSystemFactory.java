package com.capgemini.librarymanagementsystemjdbc.factory;


import java.util.Date;

import com.capgemini.librarymanagementsystemjdbc.dao.AdminDao;
import com.capgemini.librarymanagementsystemjdbc.dao.AdminDaoImplementation;
import com.capgemini.librarymanagementsystemjdbc.dao.UserDao;
import com.capgemini.librarymanagementsystemjdbc.dao.UserDaoImplementation;
import com.capgemini.librarymanagementsystemjdbc.dto.AdminInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.BooksInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.UserInformation;
import com.capgemini.librarymanagementsystemjdbc.service.AdminService;
import com.capgemini.librarymanagementsystemjdbc.service.AdminServiceImplementation;
import com.capgemini.librarymanagementsystemjdbc.service.UserService;
import com.capgemini.librarymanagementsystemjdbc.service.UserServiceImplementation;
import com.capgemini.librarymanagementsystemjdbc.validation.LibraryManagementSystemValidation;

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
	
	public static Date getDate() {
		return new Date();
	}
}
