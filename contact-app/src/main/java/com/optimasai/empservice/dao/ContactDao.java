package com.optimasai.empservice.dao;

import java.sql.*;
import com.optimasai.empservice.model.Contact;
import com.optimasai.empservice.util.DBConnection;

public class ContactDao {

        public void addContact(Contact c) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO contacts(first_name,last_name,email,mobile,city,pincode) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, c.getFirstName());
            ps.setString(2, c.getLastName());
            ps.setString(3, c.getEmailId());
            ps.setString(4, c.getMobileNumber());
            ps.setString(5, c.getCity());
            ps.setInt(6, c.getPincode());

            ps.executeUpdate();
            System.out.println("Contact Added!");

        } 
        catch (Exception e) 
        {

            if (e.getMessage().contains("email"))
            {
                System.out.println("Email already exists!");
            } 
            else if (e.getMessage().contains("mobile")) 
            {
                System.out.println("Mobile number already exists!");
            } 
            else 
            {
                System.out.println(" Error in  adding contact: " + e.getMessage());
            }
        }
    }

    
    public void showContacts() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM contacts");

            boolean found = false;

            while (rs.next()) {
                found = true;

                System.out.println("\nID: " + rs.getInt("id"));
                System.out.println("First Name: " + rs.getString("first_name"));
                System.out.println("Last Name: " + rs.getString("last_name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Mobile: " + rs.getString("mobile"));
                System.out.println("City: " + rs.getString("city"));
                System.out.println("Pincode: " + rs.getInt("pincode"));
            }

            if (!found) {
                System.out.println("No contacts found");
            }

        } catch (Exception e) {
            System.out.println("Error in fetching contacts: " + e.getMessage());
        }
    }

    
    public void deleteContact(int id) {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement("DELETE FROM contacts WHERE id=?");
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Contact Deleted!");
            else
                System.out.println("ID not found");

        } catch (Exception e) {
            System.out.println("Error in deleting: " + e.getMessage());
        }
    }

    
    public void updateContact(Contact c) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE contacts SET first_name=?,last_name=?,email=?,mobile=?,city=?,pincode=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, c.getFirstName());
            ps.setString(2, c.getLastName());
            ps.setString(3, c.getEmailId());
            ps.setString(4, c.getMobileNumber());
            ps.setString(5, c.getCity());
            ps.setInt(6, c.getPincode());
            ps.setInt(7, c.getId());

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Contact Updated!");
            else
                System.out.println("ID not found");

        } catch (Exception e) {
            System.out.println(" Error in updating: " + e.getMessage());
        }
    }

    
    public void searchByCity(String city) {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement("SELECT * FROM contacts WHERE city=?");
            ps.setString(1, city);

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            while (rs.next()) {
                found = true;

                System.out.println("\nID: " + rs.getInt("id"));
                System.out.println("First Name: " + rs.getString("first_name"));
                System.out.println("Last Name: " + rs.getString("last_name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Mobile: " + rs.getString("mobile"));
                System.out.println("City: " + rs.getString("city"));
                System.out.println("Pincode: " + rs.getInt("pincode"));
            }

            if (!found)
                System.out.println("No contacts found");

        } catch (Exception e) {
            System.out.println("Error searching: " + e.getMessage());
        }
    }

   
    public void countByCity() {
        try {
            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT city, COUNT(*) FROM contacts GROUP BY city");

            while (rs.next()) {
                System.out.println(rs.getString("city") + " : " + rs.getInt(2));
            }

        } catch (Exception e) {
            System.out.println("Error in counting: " + e.getMessage());
        }
    }
}