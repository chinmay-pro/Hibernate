package com.cache;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.example.Student;

public class FirstCache {
  public static void main(String[] args) {
	  SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Student student = s.get(Student.class, 56);
		System.out.println(student);
		System.out.println("----------------------------------------------");
		Student student1 = s.get(Student.class, 56);
		System.out.println(student1);
		System.out.println(s.contains(student1));
		s.close();
		factory.close();
  }
}
