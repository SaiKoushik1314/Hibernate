package com.training;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.util.HibernateUtil;

public class SpeakerToEvent {

	public static void main(String[] args) {
		Speaker speaker3 = new Speaker("Amzad Basha");
		Set<Event> events = new HashSet<Event>();
		Event event2 = new Event("Struts Seminar");
		Event event3 = new Event("Spring Seminar");
		Event event4 = new Event("Maths Olympiad");
		events.add(event2);
		events.add(event3);
		events.add(event4);
		speaker3.setEvents(events);
		saveSpeakerData(speaker3);
		getSpeakerData(speaker3);
		System.exit(0);
	}

	private static void getSpeakerData(Speaker speaker) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        speaker = (Speaker) session.get(Speaker.class, speaker.getSpeakerId());
        System.out.println("Speaker: " + speaker.getSpeakerName());
        System.out.println("Events: ");
        System.out.println("----------------------------");
        Set<Event> events = speaker.getEvents();
        for (Event event : events) {
            System.out.println("\t" + event.getEventName());
        }
        session.close();

	}

	private static void saveSpeakerData(Speaker speaker3) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(speaker3);
			transaction.commit();
		} catch (HibernateException ex) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(ex.getMessage());
		} finally {
			session.close();
		}
	}

}
