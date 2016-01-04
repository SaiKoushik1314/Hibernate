package com.training;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.util.HibernateUtil;

public class OneToMany {
	public static Session session = HibernateUtil.getSessionFactory()
            .openSession();

	public static void main(String[] args) {
		Writer writer = new Writer("Mohd. Arshad Basha");
        Set<Story> stories = new HashSet<Story>();
        stories.add(new Story("English Story"));
        stories.add(new Story("Science Lab Test"));
        stories.add(new Story("Social Essay"));
        writer.setStories(stories);
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(writer);
            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction != null) transaction.rollback();
        } finally {
            session.close();
            System.exit(0);
        }

	}

}
