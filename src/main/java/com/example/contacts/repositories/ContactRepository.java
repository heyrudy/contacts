package com.example.contacts.repositories;

import com.example.contacts.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findContactsByAdresseVille(String addresse);

    List<Contact> findContactsByNomStartingWithIgnoreCase(String nom);
}
