package com.example.contacts.configuration;

import com.example.contacts.dto.mapper.ContactMapper;
import com.example.contacts.dto.mapper.ContactMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ContactMapper mapper() {
        return new ContactMapperImpl();
    }
}
