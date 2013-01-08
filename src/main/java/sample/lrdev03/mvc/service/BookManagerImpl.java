package sample.lrdev03.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sample.lrdev03.mvc.dao.BookDAO;
import sample.lrdev03.mvc.domain.Book;
/**
 * BookManagerImpl class.
 * @author mshanmugam
 *
 */
@Service(value="myBookService")
public class BookManagerImpl implements BookManager{
	
	@Autowired
	@Qualifier("bookDao")
	private BookDAO bookDao;

	@Transactional
	public List<Book> getBookList() {
		return bookDao.getBookList();
	}
	
	@Transactional
	public Book getBook(Long isbn) {
		return bookDao.getBook(isbn);
	}

	@Transactional
	public void addBook(Book book) {
		bookDao.addBook(book);
	}

	@Transactional
	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}

	@Transactional
	public void deleteBook(Long isbn) {
		bookDao.deleteBook(isbn);
	}
}
