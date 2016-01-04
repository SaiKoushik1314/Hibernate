package com.hql.practice;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.training.util.HibernateUtil;

public class HQLJoinTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuilder queryString = new StringBuilder("SELECT B.id, B.name, P.id, P.name ");
		queryString.append("FROM Book B, Publisher P ");
		queryString.append("WHERE B.publisher = P.id ");
		Query query = session.createQuery(queryString.toString());
		List list = query.list();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object[] obj = (Object[]) iterator.next();
			for (int i = 0; i < obj.length; i++) {
				System.out.print(obj[i] + " | ");
			}
			System.out.println();
		}
		session.close();
		System.exit(0);
	}

}
