package com.hql.practice;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import com.training.Book;
import com.training.util.HibernateUtil;

public class CriteriaTest5 {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Book bookObj = new Book();
		bookObj.setPrice(89.99);
		Criteria criteria = session.createCriteria(Book.class);
		criteria.add(Example.create(bookObj));

		List<Book> books = criteria.list();
		for (Book book : books) {
			System.out.println(book.getId() + " | " + book.getName() + " | " + book.getPublisher().getName() + " | "
					+ book.getPrice());
		}
		session.close();
		System.exit(0);
	}

}
