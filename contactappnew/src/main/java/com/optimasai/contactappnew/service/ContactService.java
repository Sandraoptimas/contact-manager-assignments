package com.optimasai.contactappnew.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optimasai.contactappnew.exception.ResourceNotFoundException;
import com.optimasai.contactappnew.model.Contact;
import com.optimasai.contactappnew.repository.ContactRepository;

@Service
public class ContactService {

    @Autowired
    private ContactRepository repo;

    public Contact saveContact(Contact contact) {
        return repo.save(contact);
    }

    public List<Contact> getAllContacts() {
        return repo.findAll();
    }

    public List<Contact> getByCity(String city) {

        List<Contact> list = repo.findByCity(city);

        if (list.isEmpty()) {
            throw new ResourceNotFoundException("No contacts found in city: " + city);
        }

        return list;
    }

    public long countByCity(String city) {
        return repo.countByCity(city);
    }

    public Contact getById(int id) {
    	return repo.findById(id)
    	        .orElseThrow(() -> new ResourceNotFoundException("Contact not found with ID: " + id));
    }

    public String deleteContact(int id) {

        Contact contact = getById(id); 
        repo.delete(contact);

        return "Deleted successfully";
    }
}