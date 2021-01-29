package com.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Map {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Emp myEmp = new Emp();
		Emp myEmp2 = new Emp();
		myEmp.setEname("Chinmay");
		myEmp2.setEname("Mihir");
		Project p = new Project();
		Project p2 = new Project();
		p.setProjectName("Ecom");
		p2.setProjectName("Ml based chat bot");
		
		List<Emp> l1 = new ArrayList<Emp>();
		List<Project> l2 = new ArrayList<Project>();
		l1.add(myEmp);
		l1.add(myEmp2);
		l2.add(p);
		l2.add(p2);
		
		myEmp.setProjects(l2);
		p2.setEmps(l1);
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(myEmp);
		s.save(myEmp2);
		s.save(p);
		s.save(p2);
		tx.commit();
		s.close();
		factory.close();
	}
}
