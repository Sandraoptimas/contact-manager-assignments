package com.optimasai.empservice.test;

import java.util.Scanner;

public class ContactRepo {

    Contact[] contacts = new Contact[3];
    Scanner sc = new Scanner(System.in);

    public void setContact() {

        for (int i = 0; i < contacts.length; i++) {

            System.out.println("\nEnter details for Contact " + ( i+1 ));

            contacts[i] = new Contact(); 

            System.out.println("Enter First Name:");
            contacts[i].setFirstName(sc.next());

            System.out.println("Enter Last Name:");
            contacts[i].setLastName(sc.next());

            System.out.println("Enter Email Id:");
            contacts[i].setEmailId(sc.next());

            System.out.println("Enter Mobile No:");
            contacts[i].setMobileNumber(sc.next());

            System.out.println("Enter City:");
            contacts[i].setCity(sc.next());

            System.out.println("Enter Pincode:");
            contacts[i].setPincode(sc.nextInt());
        }
    }

    public void getContact() {

        System.out.println("\nALL CONTACTS-");

        for (int i = 0; i < contacts.length; i++) {

            System.out.println("\nContact " + (i + 1));
            System.out.println("First Name: "+ contacts[i].getFirstName());
            System.out.println("Last Name: "+ contacts[i].getLastName());
            System.out.println("EmailId: "+ contacts[i].getEmailId());
            System.out.println("Mobile No: "+ contacts[i].getMobileNumber());
            System.out.println("City: " +contacts[i].getCity());
            System.out.println("Pincode: " + contacts[i].getPincode());
        }
    }
}