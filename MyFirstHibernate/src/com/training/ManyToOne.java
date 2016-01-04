package com.training;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.util.HibernateUtil;

public class ManyToOne {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Address address = new Address("Plot 89, Om Nagar", "Hyderabad", "AP", "500028");
			// By using cascade=all option the address need not be saved
			// explicitly when the student object is persisted the address will
			// be automatically saved.
			// session.save(address);
			Student student1 = new Student("Md. Arshad Basha", address);
			Student student2 = new Student("Md. Afsar Basha", address);
			session.save(student1);
			session.save(student2);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.exit(0);
	}

}
