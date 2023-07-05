package com.example.chi_it_contact_book.Entities;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode()
@ToString()
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

    @OneToOne(
            mappedBy = "user"
    )
   private Contact contact;

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}
