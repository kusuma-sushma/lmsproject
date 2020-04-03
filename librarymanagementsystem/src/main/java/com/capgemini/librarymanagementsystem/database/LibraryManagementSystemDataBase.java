package com.capgemini.librarymanagementsystem.database;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dto.AdminInformation;
import com.capgemini.librarymanagementsystem.dto.BooksInformation;
import com.capgemini.librarymanagementsystem.dto.UserInformation;
import com.capgemini.librarymanagementsystem.dto.UserRequestInformation;

public class LibraryManagementSystemDataBase {
		
	public static final List<UserInformation> user= new LinkedList<UserInformation>();
	public static final List<AdminInformation> admin = new LinkedList<AdminInformation>();
    public static final List<BooksInformation> book = new LinkedList<BooksInformation>();
    public static final List<UserRequestInformation> requests=new LinkedList<UserRequestInformation>();
    
}