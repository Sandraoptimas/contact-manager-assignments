package com.optimasai.empservice.main;

import java.util.Scanner;
import com.optimasai.empservice.dao.ContactDao;
import com.optimasai.empservice.model.Contact;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ContactDao dao = new ContactDao();

        int choice;

        do {
        	System.out.println("\n1.Add 2.Show 3.Delete 4.Update 5.Search 6.Count 7.Exit");
        	System.out.print("Enter choice: ");
        	choice = sc.nextInt();
        	sc.nextLine();
            switch (choice) {

                case 1:
                    Contact c = new Contact();

                    System.out.print("First Name: ");
                    c.setFirstName(sc.next());

                    System.out.print("Last Name: ");
                    c.setLastName(sc.next());

                    System.out.print("Email: ");
                    c.setEmailId(sc.next());

                    System.out.print("Mobile: ");
                    c.setMobileNumber(sc.next());

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
                    Contact u = new Contact();

                    System.out.print("Enter ID: ");
                    u.setId(sc.nextInt());

                    System.out.print("First Name: ");
                    u.setFirstName(sc.next());

                    System.out.print("Last Name: ");
                    u.setLastName(sc.next());

                    System.out.print("Email: ");
                    u.setEmailId(sc.next());

                    System.out.print("Mobile: ");
                    u.setMobileNumber(sc.next());

                    System.out.print("City: ");
                    u.setCity(sc.next());

                    System.out.print("Pincode: ");
                    u.setPincode(sc.nextInt());

                    dao.updateContact(u);
                    break;

                case 5:
                    System.out.print("Enter City: ");
                    dao.searchByCity(sc.next());
                    break;

                case 6:
                    dao.countByCity();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);
    }
}