package com.optimasai.empservice.test;

public class Contact {

    private String firstName;
    private String lastName;
    private String emailId;
    private String mobileNumber;
    private String city;
    private int pincode;

    

    public String getFirstName() { 
    	return firstName; 
    	}
    public void setFirstName(String firstName) { 
    	this.firstName = firstName; 
    	}

    public String getLastName() {
    	return lastName; 
    	}
    public void setLastName(String lastName) { 
    	this.lastName = lastName;
    	}

    public String getEmailId() { 
    	return emailId; 
    	}
    public void setEmailId(String emailId) {
    	this.emailId = emailId; 
    	}

    public String getMobileNumber() {
    	return mobileNumber;
    	}
    public void setMobileNumber(String mobileNumber) {
    	this.mobileNumber = mobileNumber; 
    	}

    public String getCity() {
    	return city; 
    	}
    public void setCity(String city) {
    	this.city = city; 
    	}

    public int getPincode() { 
    	return pincode; 
    	}
    public void setPincode(int pincode) { 
    	this.pincode = pincode; 
    	}
}