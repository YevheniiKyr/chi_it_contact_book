package com.example.chi_it_contact_book.Repositories;

import com.example.chi_it_contact_book.Entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
    @Modifying
    @Transactional
    @Query(
            value = "DELETE FROM Email WHERE id = :id"
    )
    void deleteByIdNative(@Param("id") Long id);
}


