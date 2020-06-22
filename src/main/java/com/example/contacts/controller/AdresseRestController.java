package com.example.contacts.controller;

import com.example.contacts.entities.Adresse;
import com.example.contacts.services.AdresseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "adresse app")
public class AdresseRestController {

    AdresseService service;

    @Autowired
    public AdresseRestController(AdresseService service) {
        this.service = service;
    }

    @GetMapping("/adresses/page/{page}")
    public List<Adresse> getAdressesByPage(@PathVariable(name = "page") int page) {
        return service.getAdressesByPage(page);
    }
}
