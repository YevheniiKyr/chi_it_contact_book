package com.example.chi_it_contact_book.Repositories;

import com.example.chi_it_contact_book.Entities.Email;
import com.example.chi_it_contact_book.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
}

