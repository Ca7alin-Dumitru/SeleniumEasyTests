package com.seleniumeasy.hibernate;

import com.seleniumeasy.hibernate.entity.Customer;
import com.seleniumeasy.hibernate.util.HibernateUtil;
import org.hibernate.*;

import java.util.List;

public class GetACustomer {
    public void getACustomer(){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            List<Customer> customers = session.createQuery("FROM Customer", Customer.class).list();
            customers.forEach(c -> System.out.println(c.getFirstName()));
            for(Customer customer : customers){
                System.out.println(customer.getAddress());
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
