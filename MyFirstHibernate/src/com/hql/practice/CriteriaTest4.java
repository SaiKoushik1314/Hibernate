package com.hql.practice;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.training.Book;
import com.training.util.HibernateUtil;

public class CriteriaTest4 {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Book.class);
		criteria.createAlias("publisher", "P");
		criteria.add(Restrictions.eq("P.id", 4L));
		List<Book> books = criteria.list();
		for (Book book : books) {
			System.out.println(book.getId() + " | " + book.getName() + " | " + book.getPublisher().getName() + " | "
					+ book.getPrice());
		}
		session.close();
		System.exit(0);
	}

}
