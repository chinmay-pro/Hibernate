package com.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class EmDemo {
 public static void main(String[] args) {
	 SessionFactory factory = new Configuration().configure().buildSessionFactory();
	 Student myStudent = new Student();
	 myStudent.setName("Mihir Kulthe");
	 myStudent.setCity("Pune");
	 
	 Certificate cert = new Certificate();
	 cert.setCourse("Spring Framework");
	 cert.setDuration("4 Months");
	 myStudent.setCerti(cert);
	 
	 Session s = factory.openSession();
	 Transaction tx = s.beginTransaction();
	 s.save(myStudent);
	 tx.commit();
	 s.close();
	 factory.close();
 }
}
