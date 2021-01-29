package com.example;


import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class FetchData {
//	Get, Load
	public static void main( String[] args )
    {
         SessionFactory factory = new Configuration().configure().buildSessionFactory();
         Session session = factory.openSession();
//         Get - id - 1
         Student student = (Student)session.load(Student.class, 2);
         System.out.println(student);
         
         Address ad = (Address) session.get(Address.class,1);
         System.out.println(ad.getAddressId() + " : " + ad.getStreet() + " : " + ad.getCity() + " : " + ad.isOpen() + " : " + ad.getAddedDate());
         session.close();
         factory.close();
    }
}
