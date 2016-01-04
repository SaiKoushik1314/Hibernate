package com.training;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.util.HibernateUtil;

public class EventToSpeaker {

	public static void main(String[] args) {
		Event event1 = new Event("Hibernate Seminar");
        Set<Speaker> speakers = new HashSet<Speaker>();
        Speaker speaker1 = new Speaker("Mohd. Arshad Basha");
        Speaker speaker2 = new Speaker("Mohd. Afsar Basha");
        speakers.add(speaker1);
        speakers.add(speaker2);
        event1.setSpeakers(speakers);
        saveEventData(event1);
        getEventData(event1);
        System.exit(0);
	}

	private static void getEventData(Event event1) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        event1 = (Event) session.get(Event.class, event1.getEventId());
        System.out.println("Event: " + event1.getEventName());
        System.out.println("Speakers: ");
        System.out.println("----------------------------");
        Set<Speaker> speakers = event1.getSpeakers();
        for (Speaker speaker : speakers) {
            System.out.println("\t" + speaker.getSpeakerName());
        }
        session.close();		
	}

	private static void saveEventData(Event event1) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(event1);
            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction != null) transaction.rollback();
            System.out.println(ex.getMessage());
        } finally {
            session.close();
        }		
	}

}
