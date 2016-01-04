package com.hql.practice;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.training.Book;
import com.training.util.HibernateUtil;

public class HQLGroupTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("SELECT COUNT(B.id) FROM Book B GROUP BY B.publisher");
		List<Book> list = query.list();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next().toString());
		}
		session.close();
		System.exit(0);
	}

}
