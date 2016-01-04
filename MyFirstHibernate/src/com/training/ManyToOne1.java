package com.training;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.util.HibernateUtil;

public class ManyToOne1 {
	 public static Session session = HibernateUtil.getSessionFactory()
	            .openSession();

	public static void main(String[] args) {
		Writer writer1 = new Writer("Mohd. Afsar Basha");
        Story story1 = new Story("Struts1.pptx", writer1);
        Story story2 = new Story("Spring2.pptx", writer1);
        Story story3 = new Story("JSP3.pptx", writer1);
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(story1);
            session.save(story2);
            session.save(story3);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            System.exit(0);
        }


	}

}
