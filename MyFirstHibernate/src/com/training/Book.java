package com.training;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@NamedQueries({ @NamedQuery(name = "showBookPrice", query = "SELECT B.id, B.name, B.price, P.name FROM Book B, Publisher P WHERE B.publisher = P.id AND P.id = :pubId") })

@Entity
@Table(name = "APP.BOOK")
public class Book {
	private long id;
	private String name;
	private Publisher publisher;

	public Book() {
	}

	public Book(String name) {
		this.name = name;
	}

	public Book(String name, Publisher publisher) {
		this.name = name;
		this.publisher = publisher;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "BOOK_ID")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "BOOK_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PUB_ID")
	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	private double price;

	@Column(name = "BOOK_PRICE")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
