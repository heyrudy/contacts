package com.example.contacts.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "PERSONNES")
public class Contact implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK")
    Long id;
    String civilite;
    String nom;
    String prenom;
    @ManyToOne
    @JoinTable(name = "CONTACTS_ADRESSES",
            joinColumns = @JoinColumn(name = "FK_PERSONNE"),
            inverseJoinColumns = @JoinColumn(name = "FK_ADRESSE"))
    Adresse adresse;
}
