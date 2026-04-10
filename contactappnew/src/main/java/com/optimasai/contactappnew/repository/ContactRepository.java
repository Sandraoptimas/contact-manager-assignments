package com.optimasai.contactappnew.repository;

import com.optimasai.contactappnew.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer>
{

    List<Contact> findByCity(String city);

    long countByCity(String city);
}