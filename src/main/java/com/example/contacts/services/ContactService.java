package com.example.contacts.services;

import com.example.contacts.dto.ContactDto;
import com.example.contacts.dto.mapper.ContactMapper;
import com.example.contacts.entities.Contact;
import com.example.contacts.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

    ContactRepository repository;
    ContactMapper mapper;

    @Autowired
    public ContactService(ContactRepository repository, ContactMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ContactDto> getContacts() {
        return repository.findAll()
                .stream()
                .map(mapper::contactToContactDto)
                .collect(Collectors.toList());
    }

    public Contact getContactById(long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pas de contact pour " + id));
    }

    public List<Contact> getContactsByAdresseVilleWithIgnoreCase(String adresse) {
        return repository.findContactsByAdresseVille(adresse);
    }

    public List<Contact> getContactsByNomInUpperCase(String nom) {
        return repository.findContactsByNomStartingWithIgnoreCase(nom);
    }

    public Contact addContact(ContactDto dto) {
        Contact contact = mapper.contactDtoToContact(dto);
        return repository.save(contact);
    }

    public Contact updateContactById(long id, ContactDto dto) {
        Contact contact = mapper.contactDtoToContact(dto);
        contact.setId(id);
        return repository.save(contact);
    }

    public void deleteContactById(long id) {
        repository.deleteById(id);
    }
}
