package sample.lrdev03.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sample.lrdev03.mvc.dao.AuthorDAO;
import sample.lrdev03.mvc.domain.Author;

@Service(value="myAuthorService")
public class AuthorManagerImpl implements AuthorManager{
	
	@Autowired
	@Qualifier("authorDao")
	AuthorDAO authorDAO;

	@Transactional
	public List<Author> getAuthors() {
		return authorDAO.getAuthors();
		
	}
	
	@Transactional
	public Author getAuthor(Long id) {
		return authorDAO.getAuthor(id);
	}
	
	@Transactional
	public void addAuthor(Author author) {
		authorDAO.addAuthor(author);
	}
	
	@Transactional
	public void updateAuthor(Author author) {
		authorDAO.updateAuthor(author);
		
	}

	public void deleteAuthor(Long id) {
		authorDAO.deleteAuthor(id);
	}

}
