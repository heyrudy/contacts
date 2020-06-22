package com.example.contacts.services;

import com.example.contacts.entities.Adresse;
import com.example.contacts.repositories.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdresseService {

    AdresseRepository repository;

    @Autowired
    public AdresseService(AdresseRepository repository) {
        this.repository = repository;
    }

    public List<Adresse> getAdressesByPage(int page) {
        Pageable firstPageWithTenElements = PageRequest.of(page, 10);
        Page<Adresse> pages = repository.findAll(firstPageWithTenElements);
        return pages.get()
                .collect(Collectors.toList());
    }
}
