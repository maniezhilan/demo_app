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
	public Book getBook(Long isbn) {
		String hql = "from MyBook as book where book.isbnNumber = :isbn";
		return (Book) sessionFactory.getCurrentSession().createQuery(hql).setParameter("isbn",isbn).uniqueResult();
	}
	public void addBook(final Book book) {
		sessionFactory.getCurrentSession().save(book);
	}
	public void updateBook(Book book) {
		sessionFactory.getCurrentSession().update(book);
	}
	public void deleteBook(Long isbn) {
		String hql = "delete MyBook as book where book.isbnNumber= :isbn";
		sessionFactory.getCurrentSession().createQuery(hql).setParameter("isbn",isbn).executeUpdate();
	}

}
