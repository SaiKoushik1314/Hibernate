package com.hql.practice;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.training.Book;
import com.training.util.HibernateUtil;

public class SessionLoad {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Book book = (Book) session.load(Book.class, 50L);
			if (book != null) {
				System.out.println(book.getId() + " | " + book.getName() + " | " + book.getPublisher().getName());
			} else {
				System.out.println("No book available.");
			}
		} catch (HibernateException e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			session.close();
		}
		System.exit(0);

	}

}
