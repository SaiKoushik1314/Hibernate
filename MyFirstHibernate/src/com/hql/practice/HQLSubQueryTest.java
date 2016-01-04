package com.hql.practice;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.training.Book;
import com.training.util.HibernateUtil;

public class HQLSubQueryTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuilder queryString = new StringBuilder("FROM Book B ");
		queryString.append("WHERE B.publisher = ");
		queryString.append("(SELECT id FROM Publisher where id = :pubId)");
		Query query = session.createQuery(queryString.toString());
		query.setLong("pubId", 25);
		List<Book> books = query.list();
		if (books.size() == 0) {
			System.out.println("No Books available.");
		} else {
			for (Book book : books) {
				System.out.println(book.getId() + " | " + book.getName() + " | " + book.getPublisher().getName());
			}
		}
		session.close();
		System.exit(0);

	}

}
