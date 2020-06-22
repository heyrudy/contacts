package com.example.contacts.controller;

import com.example.contacts.dto.ContactDto;
import com.example.contacts.entities.Contact;
import com.example.contacts.services.ContactService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "contact app")
public class ContactRestController {

    ContactService service;

    @Autowired
    public ContactRestController(ContactService service) {
        this.service = service;
    }

    @ApiOperation(value = "Get all contacts")
    @GetMapping(value = "/contacts")
    public List<ContactDto> getContacts() {
        return service.getContacts();
    }

    @ApiOperation(value = "Get a contact by id")
    @GetMapping(value = "/contacts/id/{pk}")
    public Contact getContactById(@PathVariable(name = "pk") long id) {
        return service.getContactById(id);
    }

    @ApiOperation(value = "Get a contact by name of its adress")
    @GetMapping(value = "/contacts/ville/{adresse}")
    public List<Contact> getContactsByAdresseVilleWithIgnoreCase(@PathVariable(name = "adresse") String adresse) {
        return service.getContactsByAdresseVilleWithIgnoreCase(adresse);
    }


    @ApiOperation(value = "Get a contact by name")
    @GetMapping(value = "/contacts/nom/{nom}")
    public List<Contact> getContactsByNomInUpperCase(@PathVariable(name = "nom") String nom) {
        return service.getContactsByNomInUpperCase(nom);
    }

    @ApiOperation(value = "Create a new contact")
    @PostMapping(value = "/contacts")
    public Contact addContact(@RequestBody ContactDto dto) {
        return service.addContact(dto);
    }

    @ApiOperation(value = "Update a contact")
    @PutMapping("/contacts/{pk}")
    public Contact updateContactById(@PathVariable(name = "pk") long id, @RequestBody ContactDto dto) {
        return service.updateContactById(id, dto);
    }

    @DeleteMapping(value = "/contacts/{pk}")
    public void deleteContactById(@PathVariable(name = "pk") long id) {
        service.deleteContactById(id);
    }
}
