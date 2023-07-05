package com.example.chi_it_contact_book.Entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"contact"})
@ToString()
@AllArgsConstructor
@Entity(name = "Email")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(
            nullable = false,
            name = "contact_id"
    )
    private Contact contact;


    public Email(String email) {
        this.email = email;
    }
}
