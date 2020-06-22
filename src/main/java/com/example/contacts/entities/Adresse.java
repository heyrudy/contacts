package com.example.contacts.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "ADRESSES")
public class Adresse implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK")
    Long id;
    String rue;
    @Column(name = "CODE_POSTAL")
    String codePostal;
    String ville;
    String pays;
    @OneToMany(mappedBy = "adresse")
    Collection<Contact> contacts;
}
