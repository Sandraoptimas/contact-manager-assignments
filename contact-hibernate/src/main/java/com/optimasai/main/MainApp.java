package com.optimasai.main;

import java.util.Scanner;

import com.optimasai.dao.ContactDao;
import com.optimasai.model.Contact;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ContactDao dao = new ContactDao();

        int choice;

        do {
            System.out.println("\n1.Add 2.Show 3.Delete 4.Update 5.Search 6.Count 7.Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    Contact c = new Contact();

                    System.out.print("First Name: ");
                    c.setFirstName(sc.next());

                    System.out.print("Last Name: ");
                    c.setLastName(sc.next());

                    System.out.print("Email: ");
                    c.setEmail(sc.next());

                    System.out.print("Mobile: ");
                    c.setMobile(sc.next());

                    System.out.print("City: ");
                    c.setCity(sc.next());

                    System.out.print("Pincode: ");
                    c.setPincode(sc.nextInt());

                    dao.addContact(c);
                    break;

                case 2:
                    dao.showContacts();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    dao.deleteContact(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    Contact newData = new Contact();

                    System.out.print("New First Name: ");
                    newData.setFirstName(sc.next());

                    System.out.print("New Last Name: ");
                    newData.setLastName(sc.next());

                    System.out.print("New Email: ");
                    newData.setEmail(sc.next());

                    System.out.print("New Mobile: ");
                    newData.setMobile(sc.next());

                    System.out.print("New City: ");
                    newData.setCity(sc.next());

                    System.out.print("New Pincode: ");
                    newData.setPincode(sc.nextInt());

                    dao.updateContact(id, newData);
                    break;

                case 5:
                    System.out.print("Enter city: ");
                    dao.searchByCity(sc.next());
                    break;

                case 6:
                    dao.countByCity();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;
            }

        } while (choice != 7);
    }
}