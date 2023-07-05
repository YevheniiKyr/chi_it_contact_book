package com.example.chi_it_contact_book.Repositories;

import com.example.chi_it_contact_book.Entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ContactRepository extends JpaRepository<Contact, Long> {
}

