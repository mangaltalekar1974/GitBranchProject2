
package com.velocity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// step1
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		// step2
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		// how to set value into employee1 object (becoz may employee has 1 address)
		Employee emp1 = new Employee();
		emp1.setName("ash");
		emp1.setEmail("raj@123");

		Employee emp2 = new Employee();
		emp2.setName("tai");
		emp2.setEmail("rani@123");
		// how to set value into address object
		Address address = new Address();
		address.setCity("pune");
		address.setState("maharastra");
		address.setCountry("india");
		address.setPincode("534342");

		// set add into emp1 and emp2
		emp1.setAddress(address);
		emp2.setAddress(address);
		s.save(emp1);
		s.save(emp2);
		t.commit();
	}

}
