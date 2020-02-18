package com.seleniumeasy.hibernate;

import org.hibernate.*;

import data.generator.*;

import com.seleniumeasy.hibernate.entity.Customer;
import com.seleniumeasy.hibernate.util.HibernateUtil;

public class CreateDB {

    public void createACustomer(int customers){
        Transaction transaction = null;
        for(int i = 0; i < customers; i++){
            Customer customer = new Customer(Name.firstName(),
                    Name.lastName(),
                    Email.email("test"),
                    Phone.phoneNumber(),
                    Address.fullAddress(),
                    Address.city(),
                    Address.state(),
                    Address.zipCode(),
                    "www.youtube.com",
                    "yes",
                    Name.fullName() + "project description!");
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                // start a transaction
                transaction = session.beginTransaction();
                // save the customer objects
                session.save(customer);
                // commit transaction
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
    }
}
