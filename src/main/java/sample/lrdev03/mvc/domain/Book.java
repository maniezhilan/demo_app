package sample.lrdev03.mvc.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;

@Entity(name="MyBook")
@Table(name="BOOKS", catalog = "myportaldb", uniqueConstraints = {
		@UniqueConstraint(columnNames = "TITLE"),
		@UniqueConstraint(columnNames = "ISBN_NUMBER") })
public class Book implements Serializable{

	private static final long serialVersionUID = -6639736156994732462L;
	
	private int bookId;
	
	private String title;
	
	private String summary;
	
	private Long isbnNumber;
	
	private Set<Author> authors = new HashSet<Author>(0);	

	public Book(String title, Set<Author> authors, long isbnNumber, String summary) {
		this.title = title;
		this.authors = authors;
		this.isbnNumber = isbnNumber;
		this.summary = summary;
		
	}
	
	public Book() {
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BOOK_ID")
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	
	@Column(name="TITLE")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "BOOK_AUTHOR", catalog = "myportaldb", joinColumns = { 
			@JoinColumn(name = "BOOK_ID")},
			inverseJoinColumns = { @JoinColumn(name = "AUTHOR_ID") })
	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Column(name="ISBN_NUMBER")
	public Long getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(Long isbnNumber) {
		this.isbnNumber = isbnNumber;
	}
	
	@Column(name="SUMMARY")
	@Type(type="text")
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
}