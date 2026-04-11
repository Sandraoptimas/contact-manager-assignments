package com.optimasai.contactappnew.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.optimasai.contactappnew.model.Contact;
import com.optimasai.contactappnew.service.ContactService;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/add")
    public Contact addContact(@RequestBody Contact contact) {
        return contactService.saveContact(contact);
    }

    @GetMapping("/all")
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/city/{city}")
    public List<Contact> getByCity(@PathVariable String city) 
    {
        return contactService.getByCity(city);
    }

    @GetMapping("/count/{city}")
    public long countByCity(@PathVariable String city)
    {
        return contactService.countByCity(city);
    }

    
    @PutMapping("/update/{id}")
    public Contact updateContact(@PathVariable int id, @RequestBody Contact contact) {

        Contact existing = contactService.getById(id);

        existing.setFirstName(contact.getFirstName());
        existing.setLastName(contact.getLastName());
        existing.setEmail(contact.getEmail());
        existing.setMobile(contact.getMobile());
        existing.setCity(contact.getCity());
        existing.setPincode(contact.getPincode());

        return contactService.saveContact(existing);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteContact(@PathVariable int id) 
    {
        return contactService.deleteContact(id);
    }
}