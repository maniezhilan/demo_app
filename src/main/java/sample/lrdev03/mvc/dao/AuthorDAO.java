package sample.lrdev03.mvc.dao;

import java.util.List;

import sample.lrdev03.mvc.domain.Author;

public interface AuthorDAO {
	List<Author> getAuthors();
	Author getAuthor(Long id);
	void addAuthor(Author author);
	void updateAuthor(Author author);
	void deleteAuthor(Long id);

}
