package com.training;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.util.HibernateUtil;

public class ContactCRUD {
	public static Session session = HibernateUtil.getSessionFactory().openSession();

	public static void main(String[] args) {
		// getAllContacts();
		// Integer contactId = insertContact();
		// getContact(contactId);
		// getContact(2);
		// updateContact(2, "Mohammed Arshad");
		// getContact(2);
		getContact(1);
		deleteContact(1);
		getContact(1);

		session.close();
		System.exit(0);
	}

	private static void deleteContact(int i) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Contact contact = (Contact) session.get(Contact.class, i);
			session.delete(contact);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}

	}

	private static void updateContact(int i, String string) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Contact contact = (Contact) session.get(Contact.class, i);
			contact.setFirstName(string);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
	}

	private static void getContact(Integer contactId) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Contact contact = (Contact) session.get(Contact.class, contactId);
			if (contact != null) {
				System.out.println("------------------------------");
				System.out.println(contact.getContactId());
				System.out.println(contact.getFirstName());
				System.out.println(contact.getLastName());
				System.out.println(contact.getDob());
				System.out.println(contact.getEmail());
				System.out.println(contact.getMobile());
				System.out.println("------------------------------");
			} else {
				System.out.println("No row exists with the contact Id: " + contactId);
			}
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}

	}

	private static Integer insertContact() {
		Transaction transaction = null;
		Integer contactId = null;
		try {
			transaction = session.beginTransaction();
			Contact contact = new Contact();
			contact.setFirstName("Afsar");
			contact.setLastName("Basha");
			contact.setDob(new Date("08/16/2008"));
			contact.setEmail("amzad.basha@gmail.com");
			contact.setMobile("+91-9391001339");
			contactId = (Integer) session.save(contact);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
		return contactId;
	}

	private static void getAllContacts() {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List<Contact> contacts = session.createQuery("from Contact").list();
			System.out.println("Retrieving " + contacts.size() + " Records:");
			System.out.println("------------------------------");
			for (Contact contact : contacts) {
				System.out.println(contact.getContactId());
				System.out.println(contact.getFirstName());
				System.out.println(contact.getLastName());
				System.out.println(contact.getDob());
				System.out.println(contact.getEmail());
				System.out.println(contact.getMobile());
				System.out.println("------------------------------");
			}
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}

	}

}
