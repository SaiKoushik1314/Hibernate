package com.hql.practice;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.Publisher;
import com.training.util.HibernateUtil;

public class HQLUpdateTest {

	public static void main(String[] args) {
		System.out.println("Publishers List BEFORE Update:");
        System.out.println("-----------------------------------------");
        showPublishers();
        updatePublisher();
        System.out.println("--------------***************------------");
        System.out.println("Publishers List AFTER Update:");
        System.out.println("-----------------------------------------");
        showPublishers();
        System.exit(0);

	}

	private static void updatePublisher() {
		  Session session = HibernateUtil.getSessionFactory().openSession();
	        Query query = session
	                .createQuery("Update Publisher set name = :pubName where id = :pubId");
	        query.setString("pubName", "TATA McGraw-Hill");
	        query.setLong("pubId", 4);
	        Transaction transaction = session.beginTransaction();
	        int i = query.executeUpdate();
	        transaction.commit();
	        System.out.println("No. of rows affected: " + i);
	        session.close();		
	}

	private static void showPublishers() {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Publisher");
        List<Publisher> pubs = query.list();
        for (Publisher pub : pubs) {
            System.out.println(pub.getId() + " | " + pub.getName());
        }
        session.close();
		
	}

}
