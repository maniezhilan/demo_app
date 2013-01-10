package sample.lrdev03.mvc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sample.lrdev03.mvc.domain.Author;

@Repository("authorDao")
public class HibernateAuthorDao implements AuthorDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Author> getAuthors() {
		return sessionFactory.getCurrentSession().createQuery("from MyAuthor as author order by name asc").list();
	}
	public Author getAuthor(Long authorId) {
		String hql = "from MyAuthor as Author where id= :authorId";
		return (Author) sessionFactory.getCurrentSession().createQuery(hql).setParameter("authorId",authorId).uniqueResult();
	}
	public void addAuthor(final Author author) {
		sessionFactory.getCurrentSession().save(author);
	}
	public void updateAuthor(Author author) {
		String hql = "update author where id= :authorId";
		sessionFactory.getCurrentSession().createQuery(hql).setParameter("authorId",author.getId()).executeUpdate();
	}
	public void deleteAuthor(Long authorId) {
		String hql = "delete author where author.id= :authorId";
		sessionFactory.getCurrentSession().createQuery(hql).setParameter("authorId",authorId).executeUpdate();
	}

}
