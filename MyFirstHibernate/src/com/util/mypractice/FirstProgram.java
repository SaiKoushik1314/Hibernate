package com.util.mypractice;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.Course;
import com.training.CourseCRUD;
import com.training.util.HibernateUtil;

public class FirstProgram {

	
	public static void main(String[] args) {
		FirstProgram p1 = new FirstProgram();
		System.exit(0);
	}

	private void deleteCourse(Long courseId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Course course = (Course) session.get(Course.class, courseId);
			session.delete(course);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	private void updateCourse(Long courseId, String courseName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Course course = (Course) session.get(Course.class, courseId);
			course.setCourseName(courseName);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	private Long saveCourse(String courseName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Long courseId = null;
		try {
			transaction = session.beginTransaction();
			Course course = new Course();
			course.setCourseName(courseName);
			courseId = (Long) session.save(course);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return courseId;
	}

	private void listCourse() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List<Course> courses = session.createQuery("from Course").list();
			for (Course course : courses) {
				System.out.println(course.getCourseId() + " - " + course.getCourseName());
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
