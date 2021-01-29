package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Mapping {
 public static void main(String[] args) {
	 SessionFactory factory = new Configuration().configure().buildSessionFactory();
	 Question q = new Question();
	 q.setQuestionId(145);
	 q.setQuestion("What is hibernate ?");
	 
	/* Answer myAnswer1 = new Answer();
	 myAnswer1.setAnswerId(24);
	 myAnswer1.setAnswer("We use hibernate instead of jdbc");
	 myAnswer1.setQ(q);
	 
	 Answer myAnswer = new Answer();
	 myAnswer.setAnswerId(246);
	 myAnswer.setAnswer("ORM tool");
	 myAnswer.setQ(q); 
	 
	 List<Answer> list = new ArrayList<Answer>();
	 list.add(myAnswer);
	 list.add(myAnswer1);
	 
	 q.setAnswers(list); */
	 
	 Session s = factory.openSession();
	 Transaction tx = s.beginTransaction();
	 	/* s.save(q);
	 	s.save(myAnswer);
	 	s.save(myAnswer1); */
	 Question qu = (Question) s.get(Question.class, 145);
	 System.out.println(qu.getQuestionId());
	 System.out.println(qu.getQuestion());
	 System.out.println(qu.getAnswers().size());
	 tx.commit();
	 s.close();
	 factory.close();
}
}
