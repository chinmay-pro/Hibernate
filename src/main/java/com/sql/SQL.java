package com.sql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.example.Student;

public class SQL {
 public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		String q = "select *  from student";
		NativeQuery nq = s.createSQLQuery(q);
		List<Object[]> l = nq.list();
		for(Object[] student: l) {
			System.out.println(student[4] + " : " + student[3]);
		}
		s.close();
        factory.close();
  }
}
