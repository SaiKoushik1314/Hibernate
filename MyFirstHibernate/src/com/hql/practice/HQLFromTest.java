package com.hql.practice;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.training.Book;
import com.training.util.HibernateUtil;

public class HQLFromTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from Book");
		List<Book> books = query.list();
		for (Book book : books) {
			System.out.println(book.getId() + " | " + book.getName() + " | " + book.getPublisher().getName());
		}
		session.close();
		System.exit(0);
	}

}
