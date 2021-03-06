package com.mkyong;

import java.util.Date;
import org.hibernate.Session;
import com.mkyong.util.HibernateUtil;
import com.mkyong.user.DBUser;

public class App {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate Annotation + Oracle");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		DBUser user = new DBUser();

		user.setUserId(102);
		user.setUsername("Hibernate101");
		user.setCreatedBy("system");
		user.setCreatedDate(new Date());

		session.save(user);
		session.getTransaction().commit();
	}
}
