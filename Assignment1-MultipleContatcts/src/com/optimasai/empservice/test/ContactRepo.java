package com.optimasai.empservice.test;

import java.util.Scanner;

public class ContactRepo {

    Contact contact1 = new Contact();
    Contact contact2 = new Contact();
    Contact contact3 = new Contact();

    Scanner sc = new Scanner(System.in);

    public void setContact() {

        System.out.println("Enter details for Contact 1");
        setSingleContact(contact1);

        System.out.println("\nEnter details for Contact 2");
        setSingleContact(contact2);

        System.out.println("\nEnter details for Contact 3");
        setSingleContact(contact3);
    }

    private void setSingleContact(Contact contact) {

        System.out.println("Enter First Name:");
        contact.setFirstName(sc.next());

        System.out.println("Enter Last Name:");
        contact.setLastName(sc.next());

        System.out.println("Enter Email Id:");
        contact.setEmailId(sc.next());

        System.out.println("Enter Mobile No:");
        contact.setMobileNumber(sc.next());

        System.out.println("Enter City:");
        contact.setCity(sc.next());

        System.out.println("Enter Pincode:");
        contact.setPincode(sc.nextInt());
    }

    public void getContact() {


        displaySingle(contact1, 1);
        displaySingle(contact2, 2);
        displaySingle(contact3, 3);
    }

    private void displaySingle(Contact contact, int num) {

        System.out.println("\nContact " +num);
        System.out.println("First Name: " +contact.getFirstName());
        System.out.println("Last Name: " + contact.getLastName());
        System.out.println("EmailId: " + contact.getEmailId());
        System.out.println("Mobile No: " + contact.getMobileNumber());
        System.out.println("City: " + contact.getCity());
        System.out.println("Pincode: " + contact.getPincode());
    }
}