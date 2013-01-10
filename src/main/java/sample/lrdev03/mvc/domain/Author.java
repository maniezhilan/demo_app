package sample.lrdev03.mvc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "MyAuthor")
@Table(name="AUTHORS",catalog = "myportaldb", uniqueConstraints = {
	@UniqueConstraint(columnNames = "AUTHOR_ID"),
	@UniqueConstraint(columnNames = "AUTHOR_NAME") })
public class Author implements Serializable{
	
	private static final long serialVersionUID = -2948659477770971615L;
	
	private long id;
	private String name;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="AUTHOR_ID", unique = true, nullable = false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="AUTHOR_NAME", unique = true, nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + "]";
	}
	
	
}
