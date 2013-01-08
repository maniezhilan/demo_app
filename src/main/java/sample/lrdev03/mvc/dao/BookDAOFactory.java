package sample.lrdev03.mvc.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sample.lrdev03.mvc.domain.Book;

public class BookDAOFactory {
	
private static List<Book> books = Collections.synchronizedList(new ArrayList<Book>());

	public static List<Book> getBookList() {
		return books;
	}

	public static Book getBook(Long isbn) {
		Book matchingBook = null;
		Book returnBook = null;

		synchronized (books) {
			for (Book book : books) {
				if (book.getIsbnNumber().equals(isbn)) {
					matchingBook = book;
					break;
				}
			}
			// --create shallow copy of the Book object
			if (matchingBook != null) {
				returnBook = new Book();
				returnBook.setAuthors(matchingBook.getAuthors());
				returnBook.setIsbnNumber(matchingBook.getIsbnNumber());
				returnBook.setTitle(matchingBook.getTitle());
				returnBook.setSummary(matchingBook.getSummary());
			}
		}
		return returnBook;
	}

	public static void addBook(Book book) {
		books.add(book);
	}
	
	

	public static void updateBook(Book book) {
		Long isbnNumber = book.getIsbnNumber();
		Book matchingBook = null;
		
		synchronized (books) {
			for (Book book_ : books) {
				if (book_.getIsbnNumber().equals(isbnNumber)) {
					matchingBook = book_;
					break;
				}
			}
			books.remove(matchingBook);
			books.add(book);
		}
		
	}

	public static void deleteBook(Long isbn) {
		synchronized(books) {
			books.remove(getBook(isbn));
		}
		
	}
}
