package com.example.chi_it_contact_book.Repositories;

import com.example.chi_it_contact_book.Entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

    @Modifying
    @Transactional
    @Query(
            value = "DELETE FROM Phone WHERE id = :id"
    )
    void deleteByIdNative(@Param("id") Long id);
}