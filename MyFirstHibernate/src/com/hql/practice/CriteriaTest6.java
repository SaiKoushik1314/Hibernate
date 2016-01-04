package com.hql.practice;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.training.Book;
import com.training.util.HibernateUtil;

public class CriteriaTest6 {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Book.class);
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.max("price"));
		projList.add(Projections.min("price"));
		projList.add(Projections.avg("price"));
		projList.add(Projections.countDistinct("id"));
		criteria.setProjection(projList);
		List<Book> list = criteria.list();
		Iterator iter = list.iterator();
		if (!iter.hasNext()) {
		System.out.println("No objects to display.");
		return;
		}
		while (iter.hasNext()) {
		Object[] obj = (Object[]) iter.next();
		for (int i = 0; i < obj.length; i++) {
		    System.out.println(obj[i]);
		}
		}

		session.close();
		System.exit(0);
	}

}
