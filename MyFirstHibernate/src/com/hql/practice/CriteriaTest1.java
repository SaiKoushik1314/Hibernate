package com.hql.practice;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.training.Book;
import com.training.util.HibernateUtil;

public class CriteriaTest1 {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Book.class);
		List<Book> books = criteria.list();
		for (Book book : books) {
		    System.out.println(book.getId() + " | " + book.getName() + " | " + book.getPublisher().getName());
		}
		session.close();
		System.exit(0);
	}

}
