package com.pegination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.example.Student;

public class HQLPegination {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Query<Student> q = s.createQuery("from Student");
		q.setFirstResult(1);
		q.setMaxResults(4);
		List<Student> l = q.list();
		for(Student st:l) {
			System.out.println(st.getCity() + " : " + st.getName() + " : " + st.getCerti().getCourse());
		}
		s.close();
		factory.close();
	}
}
