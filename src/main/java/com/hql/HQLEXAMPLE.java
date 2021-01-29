package com.hql;

import java.util.Arrays;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.example.Student;

public class HQLEXAMPLE {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		String query = "from Student where city=:x and name=:n";
		Query q = s.createQuery(query);
		q.setParameter("x","Madras");
		q.setParameter("n","Peter Surya");
//		Single = unique
//		multiple = list
		List<Student> list = q.list();
		for(Student student: list) {
			System.out.print(student.getName() + " : " + student.getCity() + " : " + student.getCerti().getCourse() + " : " + student.getCerti().getDuration());
		}
		System.out.println("\n---------------------------------------------------");
		Transaction tx = s.beginTransaction();
		//delete query
		//Query q2 = s.createQuery("delete from Student where city=:c");
		//q2.setParameter("c", "Pune");
		//q2.executeUpdate();
//		update
		// Query q2 = s.createQuery("update Student set city=:c where name=:n");
		// q2.setParameter("c","Bombay");
		// q2.setParameter("n", "Peter surya");
		// q2.executeUpdate();
		
		Query q2 = s.createQuery("select q.question,q.questionId,a.answer from Question as q INNER JOIN q.answers as a");
		List<Object []> l = q2.getResultList();
		for(Object [] arr: l) {
			System.out.println(Arrays.toString(arr));
		}
		tx.commit();
		s.close();
		factory.close();
	}
}
