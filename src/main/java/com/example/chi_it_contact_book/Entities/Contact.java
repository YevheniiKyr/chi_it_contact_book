package com.example.chi_it_contact_book.Entities;

import com.example.chi_it_contact_book.auth.User;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"emails", "phones"})
@ToString(exclude = {"emails", "phones"})
@AllArgsConstructor
@Entity(name = "Contact")
@Builder

public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String name;
    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch=FetchType.EAGER)

    private Set<Email> emails;
    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch=FetchType.LAZY)

    private Set<Phone> phones;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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
