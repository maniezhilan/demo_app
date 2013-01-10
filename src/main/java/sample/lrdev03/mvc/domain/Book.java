package sample.lrdev03.mvc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;

@Entity(name="MyBook")
@Table(name="books", catalog = "myportaldb", uniqueConstraints = {
		@UniqueConstraint(columnNames = "TITLE"),
		@UniqueConstraint(columnNames = "ISBN_NUMBER") })
public class Book implements Serializable{

	private static final long serialVersionUID = -6638836156994732462L;
	
	private long bookId;
	
	private String title;
	
	private String summary;
	
	private Long isbnNumber;
	
	private List<Author> authors = new ArrayList<Author>();

	public Book(String title, List<Author> authors, long isbnNumber, String summary) {
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
	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	
	
	@Column(name="TITLE")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@OneToMany(orphanRemoval=true)
	@JoinTable(name = "BOOK_AUTHORS", joinColumns = {
			@JoinColumn(name = "BOOK_ID")}, inverseJoinColumns = {
			@JoinColumn(name = "AUTHOR_ID")})
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> list) {
		this.authors = list;
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

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", summary="
				+ summary + ", isbnNumber=" + isbnNumber + ", authors="
				+ authors + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + (int) (bookId ^ (bookId >>> 32));
		result = prime * result
				+ ((isbnNumber == null) ? 0 : isbnNumber.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (bookId != other.bookId)
			return false;
		if (isbnNumber == null) {
			if (other.isbnNumber != null)
				return false;
		} else if (!isbnNumber.equals(other.isbnNumber))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	
	
}