package com.optimasai.dao;

import java.util.List;
import org.hibernate.Session;

import com.optimasai.model.Contact;
import com.optimasai.util.HibernateUtil;

public class ContactDao {

    
    public void addContact(Contact c) 
    {
        Session session = HibernateUtil.getFactory().openSession();

        session.beginTransaction();
        session.save(c);
        session.getTransaction().commit();

        session.close();
        System.out.println("Contact Added!");
    }

    
    public void showContacts()
    {
        Session session = HibernateUtil.getFactory().openSession();

        List<Contact> list = session
                .createQuery("FROM Contact", Contact.class)
                .getResultList();

        if (list.isEmpty()) {
            System.out.println("No contacts found");
        }

        for (Contact c : list)
        {
            System.out.println("\nID: " + c.getId());
            System.out.println("Name: " + c.getFirstName() + " " + c.getLastName());
            System.out.println("Email: " + c.getEmail());
            System.out.println("Mobile: " + c.getMobile());
            System.out.println("City: " + c.getCity());
            System.out.println("Pincode: " + c.getPincode());
        }

        session.close();
    }

   
    public void deleteContact(int id) 
    {
        Session session = HibernateUtil.getFactory().openSession();

        session.beginTransaction();

        Contact c = session.get(Contact.class, id);

        if (c != null)
        {
            session.delete(c);
            System.out.println("Contact Deleted!");
        } else
        {
            System.out.println("ID not found");
        }

        session.getTransaction().commit();
        session.close();
    }

  
    public void updateContact(int id, Contact newData) 
    {
        Session session = HibernateUtil.getFactory().openSession();

        session.beginTransaction();

        Contact c = session.get(Contact.class, id);

        if (c != null) 
        {
            c.setFirstName(newData.getFirstName());
            c.setLastName(newData.getLastName());
            c.setEmail(newData.getEmail());
            c.setMobile(newData.getMobile());
            c.setCity(newData.getCity());
            c.setPincode(newData.getPincode());

            System.out.println("Contact Updated!");
        } 
        else
        {
            System.out.println("ID not found");
        }

        session.getTransaction().commit();
        session.close();
    }

    
    public void searchByCity(String city) 
    {
        Session session = HibernateUtil.getFactory().openSession();

        List<Contact> list = session
                .createQuery("FROM Contact WHERE lower(city)=:c", Contact.class)
                .setParameter("c", city.toLowerCase())
                .getResultList();

        if (list.isEmpty())
        {
            System.out.println("No data found");
        }

        for (Contact c : list)
        {
            System.out.println("\nID: " + c.getId());
            System.out.println("First Name: " + c.getFirstName());
            System.out.println("Last name: " + c.getLastName());
            System.out.println("Emaiil: " + c.getEmail());
            System.out.println("Mobile: " + c.getMobile());
            System.out.println("City: " + c.getCity());
            System.out.println("Pincode:" + c.getPincode());
        }

        session.close();
    }

  
    public void countByCity() 
    {
        Session session = HibernateUtil.getFactory().openSession();

        List<Object[]> list = session
                .createQuery("SELECT city, COUNT(*) FROM Contact GROUP BY city")
                .getResultList();

        for (Object[] row : list)
        {
            System.out.println(row[0] + " : " + row[1]);
        }

        session.close();
    }
}