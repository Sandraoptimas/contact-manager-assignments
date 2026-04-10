package com.optimasai.contactappnew.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return repo.findByCity(city);
    }

    public long countByCity(String city) {
        return repo.countByCity(city);
    }

    public Contact getById(int id) {
        return repo.findById(id).orElse(null);
    }

    public String deleteContact(int id) {
        repo.deleteById(id);
        return "Deleted successfully";
    }
}