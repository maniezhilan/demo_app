package sample.lrdev03.mvc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sample.lrdev03.mvc.domain.Book;

@Repository("bookDao")
public class HibernateBookDao implements BookDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Book> getBookList() {
		return sessionFactory.getCurrentSession().createQuery("from MyBook as book").list();
	}
	public Book getBook(Long bookId) {
		String hql = "from MyBook as book where bookId= :bookId";
		return (Book) sessionFactory.getCurrentSession().createQuery(hql).setParameter("bookId",bookId).uniqueResult();
	}
	public void addBook(final Book book) {
		sessionFactory.getCurrentSession().save(book);
	}
	public void updateBook(Book book) {
		String hql = "update book where bookId= :bookId";
		sessionFactory.getCurrentSession().createQuery(hql).setParameter("bookId",book.getBookId()).executeUpdate();
	}
	public void deleteBook(Long bookId) {
		String hql = "delete book where book.bookId= :bookId";
		sessionFactory.getCurrentSession().createQuery(hql).setParameter("bookId",bookId).executeUpdate();
	}

}
