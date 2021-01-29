package com.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	 System.out.println("Hibernate Project");
         // Method 1
         SessionFactory factory = new Configuration().configure().buildSessionFactory();
        System.out.println(factory);
        System.out.println(factory.isClosed());
        
        Student myst = new Student();
        myst.setName("Pallavi Kulthe");
        myst.setCity("Pimpri-chinchwad");
        System.out.println(myst);
        
        Address add = new Address();
        add.setStreet("Bombay-Pune RD");
        add.setCity("Pune");
        add.setOpen(true);
        add.setAddedDate(new Date());
        add.setX(1223.89);
        
        try {
			FileInputStream fis = new FileInputStream("src/main/java/img.png");
		    byte [] data = new byte [fis.available()];
		    fis.read(data);
		    add.setImage(data);
        } catch (Exception e) {
			e.printStackTrace();
		} 
        
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        session.save(myst);
        session.save(add);
        tx.commit();
        session.close();
        System.out.println("DONE");
        /* Method 2 -  Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory(); */
    }
}
