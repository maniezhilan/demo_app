package sample.lrdev03.mvc.service;

import java.util.List;

import sample.lrdev03.mvc.domain.Author;

public interface AuthorManager {
	List<Author> getAuthors();
	Author getAuthor(Long id);
	void addAuthor(Author author);
	void updateAuthor(Author author);
	void deleteAuthor(Long id);

}
