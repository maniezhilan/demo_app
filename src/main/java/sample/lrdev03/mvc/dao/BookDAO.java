package sample.lrdev03.mvc.dao;

import java.util.List;

import sample.lrdev03.mvc.domain.Book;

public interface BookDAO
	{
		/**
		 * Retrieve book list.
		 * @return all books
		 */
		List<Book> getBookList();
		
		/**
		 * Get a book by isbn
		 * @param isbn
		 * @return book
		 */
		Book getBook(Long isbn);
		
		/**
		 * Adds a book to the catalog
		 * 
		 * @param book to added to the catalog
		 */
		void addBook(Book book);
		
		/**
		 * Updates book
		 */
		void updateBook(Book book);
		
		/**
		 * Deletes a book 
		 * @param isbn
		 */
		void deleteBook(Long isbn);

}
