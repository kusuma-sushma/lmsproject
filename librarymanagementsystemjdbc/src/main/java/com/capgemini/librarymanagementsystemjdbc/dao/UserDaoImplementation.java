package com.capgemini.librarymanagementsystemjdbc.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import com.capgemini.librarymanagementsystemjdbc.dto.AdminInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.BooksInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.UserInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystemjdbc.exception.LibraryManagementSystemException;

public class UserDaoImplementation implements UserDao {

	@Override
	public UserInformation userLogin(String email, String password) {

		try (FileInputStream fileInputStream = new FileInputStream("databaseproperties.properties")) {
			Properties properties = new Properties();
			properties.load(fileInputStream);

			Class.forName(properties.getProperty("path")).newInstance();

			String dburl = properties.getProperty("dburl");
			try (Connection connection = DriverManager.getConnection(dburl)) {
				String query = properties.getProperty("login1");
				try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
					preparedStatement.setString(1, email);
					preparedStatement.setString(2, password);
					try (ResultSet result = preparedStatement.executeQuery()) {
						if (result.next()) {
							UserInformation userInfo = new UserInformation();
							userInfo.setEmail(result.getString("email"));
							userInfo.setPassword(result.getString("password"));
							return userInfo;
						} else {
							throw new LibraryManagementSystemException("Invalid user details");
						}
					} catch (LibraryManagementSystemException lmse) {
						System.err.println(lmse.getMessage());
					}
				}

			}
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public BooksInformation searchBook(int bookId) {
		BooksInformation bookInfo = new BooksInformation();
		try (FileInputStream fileInputStream = new FileInputStream("databaseproperties.properties")) {
			Properties properties = new Properties();
			properties.load(fileInputStream);

			Class.forName(properties.getProperty("path")).newInstance();

			try (Connection connection = DriverManager.getConnection(properties.getProperty("dburl"))) {
				try (PreparedStatement preparedStatement = connection
						.prepareStatement(properties.getProperty("searchbook"))) {
					preparedStatement.setInt(1, bookId);
					ResultSet result = preparedStatement.executeQuery();
					if (result.next()) {
						bookInfo.setBookId(result.getInt("bookid"));
						bookInfo.setBookName(result.getString("bookname"));
						bookInfo.setBookAuthor(result.getString("bookauthor"));
						bookInfo.setBookCategory(result.getString("bookcategory"));
						bookInfo.setBookPublisher(result.getString("bookpublisher"));
						return bookInfo;
					} else {
						System.out.println("No such book found");
						return null;
					}
				}
			}

		} catch (Exception e) {
			System.err.println("invalid user or book credentials");
			;
		}
		return null;

	}

	@Override
	public UserRequestInformation borrowBook(UserInformation userInfo, BooksInformation bookInfo) {
		UserRequestInformation userRequestInfo = new UserRequestInformation();
		try (FileInputStream fileInputStream = new FileInputStream("databaseproperties.properties")) {
			Properties properties = new Properties();
			properties.load(fileInputStream);

			Class.forName(properties.getProperty("path")).newInstance();

			try (Connection connection = DriverManager.getConnection(properties.getProperty("dburl"))) {
				try (PreparedStatement preparedStatement = connection
						.prepareStatement(properties.getProperty("borrowbook"))) {
					preparedStatement.setInt(1, bookInfo.getBookId());
					preparedStatement.setString(2, bookInfo.getBookName());
					preparedStatement.setInt(3, userInfo.getUserId());
					preparedStatement.setString(4, userInfo.getUsername());
					preparedStatement.setString(5, userRequestInfo.setStatus("not approved"));
					int count = preparedStatement.executeUpdate();
					if (count != 0) {
						return userRequestInfo;
					} else {
						throw new LibraryManagementSystemException("credentials are not matching");
					}
				} catch (LibraryManagementSystemException lmse) {
					System.err.println(lmse.getMessage());
				}
			}

		} catch (Exception e) {
			System.err.println("invalid user or book credentials");
		}
		return null;

	}

	@Override
	public UserRequestInformation returnBook(UserInformation userInfo, BooksInformation bookInfo) {
		UserRequestInformation userRequestInfo = new UserRequestInformation();
		try (FileInputStream fileInputStream = new FileInputStream("databaseproperties.properties")) {
			Properties properties = new Properties();
			properties.load(fileInputStream);

			Class.forName(properties.getProperty("path")).newInstance();

			try (Connection connection = DriverManager.getConnection(properties.getProperty("dburl"))) {

				try (PreparedStatement preparedStatement = connection
						.prepareStatement(properties.getProperty("updatebook1"))) {
					preparedStatement.setString(1, userRequestInfo.setStatus("returning"));
					preparedStatement.setInt(2, bookInfo.getBookId());
					userRequestInfo.setBookInfo(bookInfo);
					userRequestInfo.setUserInfo(userInfo);
					int count = preparedStatement.executeUpdate();
					if (count != 0) {
						return userRequestInfo;
					} else {
						throw new LibraryManagementSystemException("credentials are not matching");
					}
				} catch (LibraryManagementSystemException lmse) {
					System.err.println(lmse.getMessage());
				}

			}
		} catch (Exception e) {
			System.err.println("invalid user or book credentials");
			;
		}
		return null;

	}

	@Override
	public List<BooksInformation> showAllBooks() {
		try (FileInputStream fileInputStream = new FileInputStream("databaseproperties.properties")) {
			Properties properties = new Properties();
			properties.load(fileInputStream);

			Class.forName(properties.getProperty("path")).newInstance();

			try (Connection connection = DriverManager.getConnection(properties.getProperty("dburl"))) {
				try (Statement statement = connection.createStatement()) {
					try (ResultSet result = statement.executeQuery(properties.getProperty("showallbooks"))) {
						List<BooksInformation> bookInfo = new LinkedList<BooksInformation>();
						while (result.next()) {
							BooksInformation book = new BooksInformation();
							book.setBookId(result.getInt("bookid"));
							book.setBookName(result.getString("bookname"));
							book.setBookAuthor(result.getString("bookauthor"));
							book.setBookCategory(result.getString("bookcategory"));
							book.setBookPublisher(result.getString("bookpublisher"));
							bookInfo.add(book);
						}
						return bookInfo;
					}
				}
			}
		} catch (Exception e) {
			System.err.println("invalid user or book credentials");
			;
		}
		return null;

	}

}