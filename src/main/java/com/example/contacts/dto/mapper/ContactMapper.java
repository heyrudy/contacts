package com.example.contacts.dto.mapper;

import com.example.contacts.dto.ContactDto;
import com.example.contacts.entities.Contact;
import org.mapstruct.Mapper;

@Mapper
public interface ContactMapper {

    ContactDto contactToContactDto(Contact contact);

    Contact contactDtoToContact(ContactDto dto);
}
