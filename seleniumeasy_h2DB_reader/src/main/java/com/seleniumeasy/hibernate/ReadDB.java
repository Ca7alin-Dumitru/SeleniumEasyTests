package com.seleniumeasy.hibernate;

import com.seleniumeasy.hibernate.entity.Customer;
import com.seleniumeasy.hibernate.util.HibernateUtil;
import io.qameta.allure.Step;
import org.hibernate.*;
import org.testng.annotations.DataProvider;

import java.util.List;

public class ReadDB {
    @Step
    @DataProvider(name="formValuesWithDataBase")
    public Object[][] getACustomer(){
        Transaction transaction = null;
        CreateDB createCustomers = new CreateDB();
        createCustomers.createACustomer(1);
        String [][] customer;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            List<Customer> customers = session.createQuery("FROM Customer", Customer.class).list();
            customer = new String[customers.size()][11];
            int i = 0;
            for(Customer c : customers){
                customer[i][0] = c.getFirstName();
                customer[i][1] = c.getLastName();
                customer[i][2] = c.geteMail();
                customer[i][3] = c.getPhone();
                customer[i][4] = c.getAddress();
                customer[i][5] = c.getCity();
                customer[i][6] = c.getState();
                customer[i][7] = c.getZipCode();
                customer[i][8] = c.getWebsiteOrDomainName();
                customer[i][9] = c.getHosting();
                customer[i][10] = c.getProjectDescription();
                i++;
            }
            return customer;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }
}
