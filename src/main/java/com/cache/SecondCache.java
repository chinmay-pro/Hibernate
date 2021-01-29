package com.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.Student;

public class SecondCache {
 public static void main(String[] args) {
	 SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Student student = s.get(Student.class, 56);
		System.out.println(student);
		s.close();
		Session s1 = factory.openSession();
		Student student2 = s1.get(Student.class, 56);
		System.out.println(student2);
		s1.close();
		factory.close();
	}
}
