package com.example.contacts.dto.mapper;

import com.example.contacts.dto.AdresseDto;
import com.example.contacts.entities.Adresse;
import org.mapstruct.Mapper;

@Mapper
public interface AdresseMapper {

    AdresseDto adresseToAdresseDto(Adresse contact);

    Adresse adresseDtoToAdresse(AdresseDto dto);
}
