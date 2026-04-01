package com.optimasai.empservice.test;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactRepo {

    private ArrayList<Contact> contacts = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void menu() {
        int choice;

        do {
            System.out.println("\nCONTACT MENU");
            System.out.println("1. Add Contact");
            System.out.println("2. Show Contacts");
            System.out.println("3. Delete Contact");
            System.out.println("4. Edit Contact");
            System.out.println("5. Sreach City");
            System.out.println("6. City count");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    showContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    editContact();
                    break;
                case 5:
                	searchCity();
                	break;
                case 6:
                	countByCity();
                	break;
                case 7 :
                	System.out.println("Exiting...");
                	break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);
    }

    public void addContact() {
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
        
        try 
        {
        	for (int i = 0; i < contacts.size(); i++)
        	{
        		if( contacts.get(i).getEmailId().equals(c.getEmailId()))
        		{
        			throw new Exception("Email ID already exists");
        		}
        		if( contacts.get(i).getMobileNumber().equals(c.getMobileNumber()))
        		{
        			throw new Exception("Mobile number already exists");
        		}
        	}
        	contacts.add(c);
            System.out.println("Contact Added");
        }
        catch (Exception e)
        {
        	System.out.println(e.getMessage());
        }
    }

    public void showContact() {
       

        for (int i = 0; i < contacts.size(); i++) {
            Contact c = contacts.get(i);

            System.out.println("\nIndex: " + i);
            System.out.println("First Name: " + c.getFirstName());
            System.out.println("Last Name: " + c.getLastName());
            System.out.println("Email: " + c.getEmailId());
            System.out.println("Mobile: " + c.getMobileNumber());
            System.out.println("City: " + c.getCity());
            System.out.println("Pincode: " + c.getPincode());
        }
    }

    public void deleteContact() {
        showContact();

        System.out.print("Enter index to delete: ");
        int index = sc.nextInt();

        if (index >= 0 && index < contacts.size()) 
        {
            contacts.remove(index);
            System.out.println("Contact Deleted!");
        }
        else
        {
            System.out.println("Invalid index!");
        }
    }

    public void editContact() {
        showContact();

        System.out.print("Enter index to edit: ");
        int index = sc.nextInt();

        if (index >= 0 && index < contacts.size()) {

            Contact c = contacts.get(index);

            System.out.print("New First Name: ");
            c.setFirstName(sc.next());

            System.out.print("New Last Name: ");
            c.setLastName(sc.next());

            System.out.print("New Email: ");
            c.setEmailId(sc.next());

            System.out.print("New Mobile: ");
            c.setMobileNumber(sc.next());

            System.out.print("New City: ");
            c.setCity(sc.next());

            System.out.print("New Pincode: ");
            c.setPincode(sc.nextInt());

            System.out.println("Contact Updated!");

        }
        else 
        {
            System.out.println("Invalid index");
        }
    }
    
    public void searchCity() {
    	
    	System.out.print("Enter city to search: ");
        String city = sc.next();

        for (int i = 0; i < contacts.size(); i++) {
            Contact c = contacts.get(i);

            if (c.getCity().equalsIgnoreCase(city)) 
            {

                System.out.println("\nContact Found:");
                System.out.println("First Name: " + c.getFirstName());
                System.out.println("Last Name: " + c.getLastName());
                System.out.println("Email: " + c.getEmailId());
                System.out.println("Mobile: " + c.getMobileNumber());
                System.out.println("City: " + c.getCity());
                System.out.println("Pincode: " + c.getPincode());
            }
        }
    }
    public void countByCity() {

        for (int i = 0; i < contacts.size(); i++) {

            String city = contacts.get(i).getCity();

           
            int k;
            for (k = 0; k < i; k++) {
                if (contacts.get(k).getCity().equalsIgnoreCase(city)) {
                    break;
                }
            }

            if (k < i) {
                continue;
            }

            int count = 0;

            for (int j = 0; j < contacts.size(); j++) {
                if (contacts.get(j).getCity().equalsIgnoreCase(city)) {
                    count++;
                }
            }

            System.out.println(city + " : " + count);
        }
    }
}
