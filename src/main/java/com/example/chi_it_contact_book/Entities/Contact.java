package com.example.chi_it_contact_book.Entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"emails", "phones"})
@ToString(exclude = {"emails", "phones"})
@AllArgsConstructor
@Entity(name = "Contact")

public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column (unique = true)
    private String name;
    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch=FetchType.LAZY)

    private Set<Email> emails;
    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch=FetchType.LAZY)

    private Set<Phone> phones;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    User user;

    public Contact(String name, User user) {
        this.user = user;
        this.name = name;
    }
}
