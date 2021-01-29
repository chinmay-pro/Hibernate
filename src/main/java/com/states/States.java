package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.Certificate;
import com.example.Student;

public class States {
 public static void main(String[] args) {
	// Transient
	// Persistent
	// Detached
	// Removed
	 SessionFactory f = new Configuration().configure().buildSessionFactory();
	 Student student = new Student();
	 student.setId(16);
	 student.setName("Chinmay Kulthe");
	 student.setCity("Munich");
	 student.setCerti(new Certificate("Hibernate Android Course","5 months"));
	 // Student: Transient
	 Session s = f.openSession();
	 Transaction tx = s.beginTransaction();
	 s.save(student);
	 student.setName("Chinmay");
	 tx.commit();
	 //Student : Persistent
	 s.close();
	 // Student : Detached
	 f.close();
}
}
