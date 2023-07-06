package com.example.chi_it_contact_book.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"contacts"})
@ToString(exclude = {"contacts"})
@AllArgsConstructor
@Entity
@Table(name = "user")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @JsonBackReference
    @OneToMany(
          //  cascade = CascadeType.ALL,
            mappedBy = "user"
    )
   private List<Contact> contacts;

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}
