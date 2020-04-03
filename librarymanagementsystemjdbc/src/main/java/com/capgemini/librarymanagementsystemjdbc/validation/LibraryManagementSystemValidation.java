package com.capgemini.librarymanagementsystemjdbc.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LibraryManagementSystemValidation {
	
	public static boolean validateById(String bookId) {
		Pattern pattern=Pattern.compile("[0-9]{6}");
		Matcher matcher=pattern.matcher(bookId);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}
	
	public static boolean validateByName(String bookName) {
		Pattern pattern=Pattern.compile("[A-Za-z-]*");
		Matcher matcher=pattern.matcher(bookName);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}
	
	public static boolean validateByEmail(String email) {
		Pattern pattern=Pattern.compile("\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$");
		Matcher matcher=pattern.matcher(email);
		if(matcher.matches()) {
			return true;
		}
	return false;
	}
	
	public static boolean validateByPassword(String password) {
		Pattern pattern=Pattern.compile("[a-zA-Z0-9]{6}");
		Matcher matcher=pattern.matcher(password);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}
	
	
}
