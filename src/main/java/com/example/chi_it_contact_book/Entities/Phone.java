package com.example.chi_it_contact_book.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"contact"})
@ToString()

@Entity(name = "Phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false)
    private String number;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(
            nullable = false,
            name = "contact_id"
    )
    private Contact contact;

    public Phone(String number) {
        this.number = number;
    }
}
