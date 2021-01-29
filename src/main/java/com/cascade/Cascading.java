package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class Cascading {
  public static void main(String[] args) {
	  SessionFactory factory = new Configuration().configure().buildSessionFactory();
	  Session s = factory.openSession();
	  Question q = new Question();
	  q.setQuestionId(135);
	  q.setQuestion("What is Spring ?");
	  Answer a = new Answer(343,"Devlopment");
	  Answer a2 = new Answer(344,"A FRAME WORK");
	  List<Answer> l = new ArrayList<Answer>();
	  l.add(a);
	  l.add(a2);
	  q.setAnswers(l);
	  Transaction tx = s.beginTransaction();
	  s.save(q);
	  tx.commit();
	  s.close();
	  factory.close();
 }
}
