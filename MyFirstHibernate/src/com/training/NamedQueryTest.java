package com.training;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.training.util.HibernateUtil;

public class NamedQueryTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.getNamedQuery("showBookPrice");
        query.setParameter("pubId", 1L);

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
