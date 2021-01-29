package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.example.Student;


public class Main {
 public static void main(String[] args) {
	 SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Criteria c = s.createCriteria(Student.class);
		
//		c.add(Restrictions.eq("certi.course","Core Java"));
//		c.add(Restrictions.gt("id",28));
//		c.add(Restrictions.lt("id",56));
		c.add(Restrictions.like("certi.course","Hibernate%"));
;		
		List<Student> l = c.list();
		for (Student student : l) {
			System.out.println(student);
		}
		s.close();
		factory.close();
}
}
