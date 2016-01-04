package com.training;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.training.util.HibernateUtil;

public class BookPriceUpdate {

	public static void main(String[] args) {
		System.out.println("Books List BEFORE Update:");
		System.out.println("----------------------------------");
		showBooks();
		updateBooks();
		System.out.println("----------****************--------");
		System.out.println("Books List AFTER Update:");
		System.out.println("----------------------------------");
		showBooks();
		System.exit(0);

	}

	private static void updateBooks() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("Update Book set price = :bookPrice where publisher = :pubId");
		Double price[] = { 41.99, 9.99, 75.55, 89.99, 99.99 };
		int pubIds[] = { 1, 2, 3, 4, 5 };
		int update = 0;
		for (int i = 0; i < pubIds.length; i++) {
			query.setDouble("bookPrice", price[i]);
			query.setInteger("pubId", pubIds[i]);
			session.beginTransaction();
			update += query.executeUpdate();
			session.getTransaction().commit();
		}
		System.out.println("No. of rows affected: " + update);
		session.close();

	}

	private static void showBooks() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from Book");
		List<Book> books = query.list();
		if (books.size() == 0) {
			System.out.println("No Books available.");
		} else {
			for (Book book : books) {
				System.out.println(book.getId() + " | " + book.getName() + " | " + book.getPrice() + " | "
						+ book.getPublisher().getName());
			}
		}
		session.close();

	}

}
