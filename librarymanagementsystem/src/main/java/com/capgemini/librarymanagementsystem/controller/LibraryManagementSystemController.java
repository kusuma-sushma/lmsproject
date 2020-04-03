package com.capgemini.librarymanagementsystem.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.capgemini.librarymanagementsystem.dto.BooksInformation;
import com.capgemini.librarymanagementsystem.dto.UserInformation;
import com.capgemini.librarymanagementsystem.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementSystemException;
import com.capgemini.librarymanagementsystem.factory.LibraryManagementSystemFactory;
import com.capgemini.librarymanagementsystem.service.AdminService;
import com.capgemini.librarymanagementsystem.service.UserService;
import com.capgemini.librarymanagementsystem.validation.LibraryManagementSystemValidation;

public class LibraryManagementSystemController {

	public static void main(String[] args) {
		controller();
	}

	public static void controller() {

		BooksInformation bookInfo = LibraryManagementSystemFactory.getBookInfo();
		LibraryManagementSystemValidation validation = LibraryManagementSystemFactory.getValidation();
		UserInformation userInfo = LibraryManagementSystemFactory.getUserInfo();
		AdminService adminService = LibraryManagementSystemFactory.getAdminService();
		UserService userService = LibraryManagementSystemFactory.getUserService();
		Calendar calendar = Calendar.getInstance();
		Date date = LibraryManagementSystemFactory.getDate();
		Date actualReturnDate = LibraryManagementSystemFactory.getDate();
		int choice;
		int controller1;
		int controller2;
		try (Scanner scanner = new Scanner(System.in)) {
			try {
				do {
					System.out.println("press 1 to AdminLogin");
					System.out.println("press 2 to UserLogin");
					System.out.println("********************");
					choice = scanner.nextInt();
					switch (choice) {

					case 1:
						try {
							System.out.println("Enter Email  for ex:sushma@gmail.com");
							String adminEmail = scanner.next();
							boolean isValidEmail = validation.validateByEmail(adminEmail);
							while (!isValidEmail) {
								try {
									throw new LibraryManagementSystemException("please enter valid email id");
								} catch (LibraryManagementSystemException lmse) {
									System.err.println(lmse.getMessage());
									adminEmail = scanner.next();
									if (validation.validateByEmail(adminEmail)) {
										break;
									}
								}
							}
							System.out.println("Enter password of 6 digits");
							String adminPassword = scanner.next();
							boolean isValidPassword = validation.validateByPassword(adminPassword);
							while (!isValidPassword) {
								try {
									throw new LibraryManagementSystemException("please enter valid password");
								} catch (LibraryManagementSystemException lmse) {
									System.err.println(lmse.getMessage());
									adminPassword = scanner.next();
									if (validation.validateByEmail(adminPassword)) {
										break;
									}
								}
							}
							adminService.adminLogin(adminEmail, adminPassword);
							System.out.println("Admin Logged in successfully");
//							
							do {
								System.out.println("press 1 to add user");
								System.out.println("press 2 to addbook");
								System.out.println("press 3 to show all users");
								System.out.println("press 4 to show all books");
								System.out.println("press 5 to show all requests");
								System.out.println("press 6 to issue book");
								System.out.println("press 7 to collect return books");
								System.out.println("press 8 to search book");
								System.out.println("press 9 to update book");
								System.out.println("press 10 to delete book");
								System.out.println("press beyond this to exit");
								System.out.println("**************************");
								controller1 = scanner.nextInt();

								switch (controller1) {
								case 1:
									UserInformation userInformation = LibraryManagementSystemFactory.getUserInfo();
									System.out.println("Enter userId of 6 digits");
									String userId = scanner.next();
									boolean isValidId = validation.validateById(userId);
									while (!isValidId) {
										try {
											throw new LibraryManagementSystemException("please enter valid id");
										} catch (LibraryManagementSystemException lmse) {
											System.err.println(lmse.getMessage());
											userId = scanner.next();
											if (validation.validateById(userId)) {
												break;
											}
										}
									}
									userInformation.setUserId(Integer.parseInt(userId));

									System.out.println("Enter First Name");
									String userFirstname = scanner.next();
									boolean isValidFN = validation.validateByName(userFirstname);
									while (!isValidFN) {
										try {
											throw new LibraryManagementSystemException("please enter valid First name");
										} catch (LibraryManagementSystemException lmse) {
											System.err.println(lmse.getMessage());
											userFirstname = scanner.next();
											if (validation.validateByName(userFirstname)) {
												break;
											}
										}
									}
									userInformation.setFirstname(userFirstname);

									System.out.println("Enter Last Name");
									String userLastname = scanner.next();
									boolean isValidLN = validation.validateByName(userLastname);
									while (!isValidLN) {
										try {
											throw new LibraryManagementSystemException("please enter valid last name");
										} catch (LibraryManagementSystemException lmse) {
											System.err.println(lmse.getMessage());
											userLastname = scanner.next();
											if (validation.validateByName(userLastname)) {
												break;
											}
										}
									}
									userInformation.setLastname(userLastname);

									System.out.println("Enter user Name");
									String username = scanner.next();
									boolean isValidUN = validation.validateByName(username);
									while (!isValidUN) {
										try {
											throw new LibraryManagementSystemException("please enter valid username");
										} catch (LibraryManagementSystemException lmse) {
											System.err.println(lmse.getMessage());
											username = scanner.next();
											if (validation.validateByName(username)) {
												break;
											}
										}
									}
									userInformation.setUsername(username);

									System.out.println("Enter Department");
									String userDepartment = scanner.next();
									boolean isValidDept = validation.validateByName(userDepartment);
									while (!isValidDept) {
										try {
											throw new LibraryManagementSystemException("please enter valid Department");
										} catch (LibraryManagementSystemException lmse) {
											System.err.println(lmse.getMessage());
											userDepartment = scanner.next();
											if (validation.validateByName(userDepartment)) {
												break;
											}
										}
									}
									userInformation.setDepartment(userDepartment);

									System.out.println("Enter Email ex:sushma@gmail.com");
									String userEmail = scanner.next();
									boolean isVaildEmail = validation.validateByEmail(userEmail);
									while (!isVaildEmail) {
										try {
											throw new LibraryManagementSystemException("please enter valid data");
										} catch (LibraryManagementSystemException lmse) {
											System.err.println("Enter Email id once again");
											userEmail = scanner.next();
											if (validation.validateByEmail(userEmail)) {
												break;
											}
										}
									}
									userInformation.setEmail(userEmail);

									System.out.println("Enter Password of 6 digits");
									String userPassword = scanner.next();
									boolean isVaildPassword = validation.validateByPassword(userPassword);
									while (!isVaildPassword) {
										try {
											throw new LibraryManagementSystemException("please enter valid data");
										} catch (LibraryManagementSystemException lmse) {
											System.err.println("Enter valid password once again");
											userPassword = scanner.next();
											if (validation.validateByPassword(userPassword)) {
												break;
											}
										}
									}
									userInformation.setPassword(userPassword);
									try {
										boolean add = adminService.addUser(userInformation);
										if (add) {
											System.out.println("user added succesfully");

										} else {
											System.out.println("User's email or id already exists");
										}
									} catch (Exception e) {
										System.err.println(e.getMessage());
									}
									break;
								case 2:
									BooksInformation book = LibraryManagementSystemFactory.getBookInfo();
									System.out.println("Enter book id");
									String bookId = scanner.next();
									boolean isValid = validation.validateById(bookId);
									while (!isValid) {
										try {
											throw new LibraryManagementSystemException("please enter valid id");
										} catch (LibraryManagementSystemException lmse) {
											System.err.println(lmse.getMessage());
											bookId = scanner.next();
											if (validation.validateById(bookId)) {
												break;
											}
										}
									}
									book.setBookId(Integer.parseInt(bookId));
									System.out.println("Enter book name");
									String bookName = scanner.next();
									boolean isValidName = validation.validateByName(bookName);
									while (!isValidName) {
										try {
											throw new LibraryManagementSystemException("please enter valid Name");
										} catch (LibraryManagementSystemException lmse) {
											System.err.println(lmse.getMessage());
											bookName = scanner.next();
											if (validation.validateByName(bookName)) {
												break;
											}
										}
									}
									book.setBookName(bookName);
									System.out.println("Enter category name");
									String categoryName = scanner.next();
									boolean isValidCategory = validation.validateByName(categoryName);
									while (!isValidCategory) {
										try {
											throw new LibraryManagementSystemException(
													"please enter valid category name");
										} catch (LibraryManagementSystemException lmse) {
											System.err.println(lmse.getMessage());
											categoryName = scanner.next();
											if (validation.validateByName(categoryName)) {
												break;
											}
										}
									}
									book.setBookCategory(categoryName);
									System.out.println("Enter author name");
									String authorName = scanner.next();
									boolean isValidAuthor = validation.validateByName(authorName);
									while (!isValidAuthor) {
										try {
											throw new LibraryManagementSystemException(
													"please enter valid author name");
										} catch (LibraryManagementSystemException lmse) {
											System.err.println(lmse.getMessage());
											authorName = scanner.next();
											if (validation.validateByName(authorName)) {
												break;
											}
										}
									}
									book.setBookAuthor(authorName);
									System.out.println("Enter publishers name");
									String bookPublisher = scanner.next();
									boolean isValidPublisher = validation.validateByName(bookPublisher);
									while (!isValidPublisher) {
										try {
											throw new LibraryManagementSystemException("please enter valid publisher");
										} catch (LibraryManagementSystemException lmse) {
											System.err.println(lmse.getMessage());
											bookPublisher = scanner.next();
											if (validation.validateByName(bookPublisher)) {
												break;
											}
										}
									}
									book.setBookPublisher(bookPublisher);
									boolean result = adminService.addBook(book);
									if (result)
										System.out.println("Book added successfully");
									else
										System.out.println("Book is already added");
									break;

								case 3:
									try {
										System.out.println(
												"Showing all the users who has registered with the help of admin");
										System.out.println("********************");
										List<UserInformation> listUsers = adminService.showAllUsers();
										for (UserInformation userInfo1 : listUsers) {

											System.out.println("User id ------> " + userInfo1.getUserId());
											System.out.println("User First Name --------> " + userInfo1.getFirstname());
											System.out.println("User Last Name------> " + userInfo1.getLastname());
											System.out.println("User Name------> " + userInfo1.getUsername());
											System.out.println("User Email------> " + userInfo1.getEmail());
											System.out.println("User Password------> " + userInfo1.getPassword());
											System.out.println("User Department-----> " + userInfo1.getDepartment());
											System.out.println(
													"User NoOfBooksBorrowed-----> " + userInfo1.getNoOfBooksBorrowed());
											System.out.println("********************************");
										}
									} catch (Exception e) {
										System.out.println("no books present in library");
									}
									break;

								case 4:
									try {
										System.out.println("Showing all the books present in the library");
										System.out.println("********************");
										List<BooksInformation> listBooks = adminService.showAllBooks();
										for (BooksInformation bookInfo3 : listBooks) {

											System.out.println("Book id ------> " + bookInfo3.getBookId());
											System.out.println("Book Name ------> " + bookInfo3.getBookName());
											System.out.println("Book Authour------> " + bookInfo3.getBookAuthor());
											System.out.println("Book Category ------> " + bookInfo3.getBookCategory());
											System.out.println("Book Publisher------>" + bookInfo3.getBookPublisher());
											System.out.println("********************");
										}
									} catch (Exception e) {
										System.out.println("No such book present in library");
									}
									break;
								case 5:
									try {
										System.out.println("Showing all Requests for Book");
										System.out.println("********************");
										List<UserRequestInformation> requestInfo1 = adminService.showAllRequests();
										for (UserRequestInformation info : requestInfo1) {

											System.out.println("Book id ---------- " + info.getBookInfo().getBookId());
											System.out
													.println("Book Name -------- " + info.getBookInfo().getBookName());
											System.out.println("User id----------- " + info.getUserInfo().getUserId());
											System.out
													.println("User Name -------- " + info.getUserInfo().getUsername());
											System.out.println("Book Issued ------" + info.isBookIssued());
											System.out.println("Book Returned------" + info.isBookReturned());
											System.out.println("********************");
										}
									} catch (Exception e) {
										System.out.println("no books present in library");
									}
									break;
								case 6:
									try {
										UserInformation userInfo3 = LibraryManagementSystemFactory.getUserInfo();
										BooksInformation bookInfo3 = LibraryManagementSystemFactory.getBookInfo();
										System.out.println("enter Book Id of 6 digits");
										String issueBookId = scanner.next();
										boolean isIssue = validation.validateById(issueBookId);
										while (!isIssue) {
											try {
												throw new LibraryManagementSystemException(
														"please enter valid Book id");
											} catch (LibraryManagementSystemException lmse) {
												System.err.println(lmse.getMessage());
												issueBookId = scanner.next();
												if (validation.validateById(issueBookId)) {
													break;
												}
											}
										}
										bookInfo3.setBookId(Integer.parseInt(issueBookId));
										System.out.println("enter User Id  of 6 digits");
										String issueUserId = scanner.next();
										boolean isIssueUserId = validation.validateById(issueUserId);
										while (!isIssueUserId) {
											try {
												throw new LibraryManagementSystemException(
														"please enter valid User id");
											} catch (LibraryManagementSystemException lmse) {
												System.err.println(lmse.getMessage());
												issueUserId = scanner.next();
												if (validation.validateById(issueUserId)) {
													break;
												}
											}
										}
										userInfo3.setUserId(Integer.parseInt(issueUserId));
										boolean isBookIssued = adminService.issueBook(userInfo3, bookInfo3);
										if (isBookIssued) {
											calendar.add(Calendar.DATE, 15);
											date = calendar.getTime();
											actualReturnDate = calendar.getTime();
											System.out.println("Book has issued successfully to user");
											System.out.println("Book needs to be returned by----> " + actualReturnDate);
										} else {
											System.out.println("Book cannot be issued to user");
										}

									} catch (Exception e) {
										System.out.println("Invalid user or book credentials book cannnot be issued");
									}
									break;
								case 7:
									try {
										System.out.println("Receive Returned Book");
										System.out.println("********************");
										System.out.println("Enter User Id of 6 digits");
										String userReturn = scanner.next();
										boolean isUserReturn = validation.validateById(userReturn);
										while (!isUserReturn) {
											try {
												throw new LibraryManagementSystemException(
														"please enter valid User id ");
											} catch (LibraryManagementSystemException lmse) {
												System.err.println(lmse.getMessage());
												userReturn = scanner.next();
												if (validation.validateById(userReturn)) {
													break;
												}
											}
										}
										userInfo.setUserId(Integer.parseInt(userReturn));
										System.out.println("Enter Book Id");
										String returnBook = scanner.next();
										boolean isBookReturn = validation.validateById(returnBook);
										while (!isBookReturn) {
											try {
												throw new LibraryManagementSystemException(
														"please enter valid Book id ");
											} catch (LibraryManagementSystemException lmse) {
												System.err.println(lmse.getMessage());
												userReturn = scanner.next();
												if (validation.validateById(returnBook)) {
													break;
												}
											}
										}
										bookInfo.setBookId(Integer.parseInt(returnBook));
										boolean isReceived = adminService.isBookRecevied(userInfo, bookInfo);
										if (isReceived) {
											System.out.println("Admin received returned book by user");
											System.out.println("Fine is " + userInfo.getFine());
										} else {
											System.out.println("Invalid user or book details  Admin unable to receive");
										}
									} catch (Exception e) {
										System.out.println("Exception due to invalid credentials");
									}
									break;
								case 8:
									System.out.println("Enter book id  of 6 digits to search");
									String searchById = scanner.next();
									boolean searchByBook = validation.validateById(searchById);
									while (!searchByBook) {
										try {
											throw new LibraryManagementSystemException(
													"please enter valid book id for search");
										} catch (LibraryManagementSystemException lmse) {
											System.err.println(lmse.getMessage());
											searchById = scanner.next();
											if (validation.validateById(searchById)) {
												searchByBook = true;
												break;
											}
										}
									}
									BooksInformation search = adminService.searchBook(Integer.parseInt(searchById));
									if (search != null) {

										System.out.println("book has founded");
										System.out.println("Book id----> " + search.getBookId());
										System.out.println("Book Name----> " + search.getBookName());
										System.out.println("Book Author----> " + search.getBookAuthor());
										System.out.println("Book Category----> " + search.getBookCategory());
										System.out.println("Book Publisher----> " + search.getBookPublisher());
									} else {
										System.err.println("No such book found");
									}
									break;
								case 9:
									System.out.println("Enter book id of 6 digits to update");
									String updateById = scanner.next();
									boolean updateBook = validation.validateById(updateById);
									while (!updateBook) {
										try {
											throw new LibraryManagementSystemException("please enter valid book id");
										} catch (LibraryManagementSystemException lmse) {
											System.err.println(lmse.getMessage());
											updateById = scanner.next();
											if (validation.validateById(updateById)) {
												break;
											}
										}
									}

									BooksInformation bookUpdate = adminService.updateBook(Integer.parseInt(updateById));
									if (bookUpdate != null) {

										System.out.println("press 1 to update book name");
										System.out.println("press 2 to update author");
										System.out.println("press 3 to update category");
										System.out.println("press 4 to update publisher");

										int updateBookDetails = scanner.nextInt();
										switch (updateBookDetails) {

										case 1:
											System.out.println("Enter book name");
											String bookName1 = scanner.next();
											boolean isValidName1 = validation.validateByName(bookName1);
											while (!isValidName1) {
												try {
													throw new LibraryManagementSystemException(
															"please enter valid Name");
												} catch (LibraryManagementSystemException lmse) {
													System.err.println(lmse.getMessage());
													bookName = scanner.next();
													if (validation.validateByName(bookName1)) {
														break;
													}
												}
											}
											bookUpdate.setBookName(bookName1);
											break;
										case 2:
											System.out.println("Enter author name");
											String authorName1 = scanner.next();
											boolean isValidAuthor1 = validation.validateByName(authorName1);
											while (!isValidAuthor1) {
												try {
													throw new LibraryManagementSystemException(
															"please enter valid author name");
												} catch (LibraryManagementSystemException lmse) {
													System.err.println(lmse.getMessage());
													authorName1 = scanner.next();
													if (validation.validateByName(authorName1)) {
														break;
													}
												}
											}
											bookUpdate.setBookAuthor(authorName1);
											break;
										case 3:
											System.out.println("Enter book category name");
											String categoryName1 = scanner.next();
											boolean isValidCategory1 = validation.validateByName(categoryName1);
											while (!isValidCategory1) {
												try {
													throw new LibraryManagementSystemException(
															"please enter valid author name");
												} catch (LibraryManagementSystemException lmse) {
													System.err.println(lmse.getMessage());
													categoryName1 = scanner.next();
													if (validation.validateByName(categoryName1)) {
														break;
													}
												}
											}
											bookUpdate.setBookCategory(categoryName1);
											break;

										case 4:
											System.out.println("Enter publishers name");
											String bookPublisher1 = scanner.next();
											boolean isValidPublisher1 = validation.validateByName(bookPublisher1);
											while (!isValidPublisher1) {
												try {
													throw new LibraryManagementSystemException(
															"please enter valid publisher name");
												} catch (LibraryManagementSystemException lmse) {
													System.err.println(lmse.getMessage());
													bookPublisher1 = scanner.next();
													if (validation.validateByName(bookPublisher1)) {
														break;
													}
												}
											}
											bookUpdate.setBookPublisher(bookPublisher1);
											break;

										default:
											break;
										}
										bookInfo.setBookId(Integer.parseInt(updateById));
										System.err.println("Book is updated successfully");
										break;
									} else {
										System.err.println("book is not in exixting");
									}
									break;
								case 10:
									System.out.println("Enter book id of 6 digits to remove ");
									String removeBookById = scanner.next();
									boolean isRemoved = validation.validateById(removeBookById);
									while (!isRemoved) {
										try {
											throw new LibraryManagementSystemException("please enter valid book id");
										} catch (LibraryManagementSystemException lmse) {
											System.err.println(lmse.getMessage());
											removeBookById = scanner.next();
											if (validation.validateById(removeBookById)) {
												break;
											}
										}
									}
									boolean bookRemoved = adminService.removeBook(Integer.parseInt(removeBookById));
									if (bookRemoved) {
										System.out.println("Book is removed successfully");
									} else {
										System.out.println("Invalid book details book cannot be removed");
									}
									break;
//						default:
//							break;
								} // switch controller1
									// break;
							} while (controller1 != 0); // do loop
							// break;
						} catch (InputMismatchException ime) {
							System.err.println("please enter valid credentials  input mismatch exception");
							controller();
						} catch (NoSuchElementException nsee) {
							System.err.println(
									"please enter valid credentials in case of admin no such element exception");
							controller();
						} catch (NumberFormatException nfe) {
							System.err
									.println("please enter valid credentials in case of admin number format exception");
							controller();
						} catch (Exception e) {
							System.err.println("please enter valid credentials in case of admin");
							controller();
						}
						break;

					case 2:
						try {
							System.out.println("Enter User Email id for ex:sushma@gmail.com");
							String userEmail = scanner.next();
							boolean isValidUserEmail = validation.validateByEmail(userEmail);
							while (!isValidUserEmail) {
								try {
									throw new LibraryManagementSystemException("please enter valid email id");
								} catch (LibraryManagementSystemException lmse) {
									System.err.println(lmse.getMessage());
									userEmail = scanner.next();
									if (validation.validateByEmail(userEmail)) {
										break;
									}
								}
							}
							System.out.println("Enter User password of 6 digits");
							String userPassword = scanner.next();
							boolean isValidUserPassword = validation.validateByPassword(userPassword);
							while (!isValidUserPassword) {
								try {
									throw new LibraryManagementSystemException("please enter valid password");
								} catch (LibraryManagementSystemException lmse) {
									System.err.println(lmse.getMessage());
									userPassword = scanner.next();
									if (validation.validateByPassword(userPassword)) {
										break;
									}
								}
							}
							userService.userLogin(userEmail, userPassword);
							System.out.println("User logged in successfully");
							do {
								System.out.println("press 1 to search books from library");
								System.out.println("press 2 to see all the books present in the library");
								System.out.println("press 3 to request book to admin");
								System.out.println("press 4 to return the issued book to admin");
								System.out.println("press beyond this to exit");
								System.out.println("**************************");
								controller2 = scanner.nextInt();
								switch (controller2) {
								case 1:
									System.out.println("Enter id to search");
									String searchById = scanner.next();
									boolean searchByBook = validation.validateById(searchById);
									while (!searchByBook) {
										try {
											throw new LibraryManagementSystemException(
													"please enter valid book id for search");
										} catch (LibraryManagementSystemException lmse) {
											System.err.println();
											lmse.getMessage();
											searchById = scanner.next();
											if (validation.validateById(searchById)) {
												break;
											}
										}
									}
									BooksInformation search = adminService.searchBook(Integer.parseInt(searchById));
									if (search != null) {

										System.out.println("book has founded");
										System.out.println("Book id----> " + search.getBookId());
										System.out.println("Book Name----> " + search.getBookName());
										System.out.println("Book Author----> " + search.getBookAuthor());
										System.out.println("Book Category----> " + search.getBookCategory());
										System.out.println("Book Publisher----> " + search.getBookPublisher());
									} else {
										System.err.println("No such book found");
									}
									break;
								case 2:
									try {
										System.out.println("Showing all the books present in the library");
										System.out.println("********************");
										List<BooksInformation> listBook = adminService.showAllBooks();
										for (BooksInformation bookInfo3 : listBook) {

											System.out.println("Book id ---------- " + bookInfo3.getBookId());
											System.out.println("Book Name -------- " + bookInfo3.getBookName());
											System.out.println("Book Authour------ " + bookInfo3.getBookAuthor());
											System.out.println("Book Category ------- " + bookInfo3.getBookCategory());
											System.out.println("Book Publisher--------" + bookInfo3.getBookPublisher());
											System.out.println("********************");
										}
									} catch (LibraryManagementSystemException lmse) {
										System.out.println(lmse.getMessage());
									}
									break;
								case 3:
									System.out.println("Enter book id of 6 digits");
									String bookId = scanner.next();
									boolean isValidBookId = validation.validateById(bookId);
									while (!isValidBookId) {
										try {
											throw new LibraryManagementSystemException("please enter valid book id");
										} catch (LibraryManagementSystemException lmse) {
											System.err.println(lmse.getMessage());
											bookId = scanner.next();
											if (validation.validateById(bookId)) {
												break;
											}
										}
									}
									bookInfo.setBookId(Integer.parseInt(bookId));
									System.out.println("Enter user id of 6 digits");
									String userId = scanner.next();
									boolean isValidUserId = validation.validateById(userId);
									while (!isValidUserId) {
										try {
											throw new LibraryManagementSystemException("please enter valid user id");
										} catch (LibraryManagementSystemException lmse) {
											System.err.println(lmse.getMessage());
											userId = scanner.next();
											if (validation.validateById(userId)) {
												break;
											}
										}
									}
									userInfo.setUserId(Integer.parseInt(userId));
									try {
										UserRequestInformation request = userService.borrowBook(userInfo, bookInfo);
										System.out.println("Request placed to admin");
										System.out.println("User Id----->" + request.getUserInfo().getUserId());
										System.out.println("User name---->" + request.getUserInfo().getUsername());
										System.out.println("Book Id----->" + request.getBookInfo().getBookId());
										System.out.println("Book Name----->" + request.getBookInfo().getBookName());

									} catch (LibraryManagementSystemException lmse) {

										System.err.println(lmse.getMessage());
									}
									break;
								case 4:
									System.out.println("Returning a book:");
									System.out.println("********************");
									System.out.println("Enter User Id of 6 didgits");
									String returnUser = scanner.next();
									boolean isValidReturnUserId = validation.validateById(returnUser);
									while (!isValidReturnUserId) {
										try {
											throw new LibraryManagementSystemException("please enter valid user id");
										} catch (LibraryManagementSystemException lmse) {
											System.err.println();
											lmse.getMessage();
											returnUser = scanner.next();
											if (validation.validateById(returnUser)) {
												break;
											}
										}
									}
									userInfo.setUserId(Integer.parseInt(returnUser));
									System.out.println("Enter Book Id");
									String returnBook = scanner.next();
									boolean isValidReturnBookId = validation.validateById(returnBook);
									while (!isValidReturnBookId) {
										try {
											throw new LibraryManagementSystemException("please enter valid user id");
										} catch (LibraryManagementSystemException lmse) {
											System.err.println();
											lmse.getMessage();
											returnBook = scanner.next();
											if (validation.validateById(returnBook)) {
												break;
											}
										}
									}

									bookInfo.setBookId(Integer.parseInt(returnBook));

									try {
										UserRequestInformation requestInfo = userService.returnBook(userInfo, bookInfo);
										System.out.println("Book is Returning to Admin by user");
										System.out.println("User Id ------>" + requestInfo.getUserInfo().getUserId());
										System.out.println("Book Id ------>" + requestInfo.getBookInfo().getBookId());
										System.out.println("Is Returning ------->" + requestInfo.isBookReturned());

									} catch (LibraryManagementSystemException lmse) {
										System.out.println(lmse.getMessage());
									}
									break;

								default:
									break;
								}// controller2
							} while (controller2 != 0);
						} catch (InputMismatchException ime) {
							System.err
									.println("please enter valid credentials in case of user input mismatch exception");
							controller();
						} catch (NoSuchElementException nsee) {
							System.err.println(
									"please enter valid credentials in case of user no such element exception");
							controller();
						} catch (NumberFormatException nfe) {
							System.err
									.println("please enter valid credentials in case of user number format exception");
							controller();
						} catch (Exception e) {
							controller();
						}
						break;
					} // choice
				} while (choice != 0);

			} catch (InputMismatchException ime) {

				System.err.println("please enter valid credentials input mismatch exception");
				controller();
			} catch (NoSuchElementException nsee) {
				System.err.println("please enter valid credentials in case of admin no such element exception");
				controller();
			} catch (NumberFormatException nfe) {
				System.err.println("please enter valid credentials in case of admin number format exception");
				controller();
			} catch (Exception e) {
				System.err.println("please enter valid credentials");
				controller();
			}
		}

	}

}