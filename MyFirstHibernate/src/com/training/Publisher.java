package com.training;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.OneToMany;

@Entity
@Table(name = "APP.PUBLISHER")
public class Publisher {
	private long id;
	private String name;

	public Publisher() {
	}

	public Publisher(String pubName) {
		this.name = pubName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "PUB_ID")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "PUB_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Set<Book> books;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "PUB_ID", referencedColumnName = "PUB_ID")
	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

}
