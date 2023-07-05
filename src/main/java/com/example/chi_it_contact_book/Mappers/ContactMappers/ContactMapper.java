package com.example.chi_it_contact_book.Mappers.ContactMappers;

import com.example.chi_it_contact_book.Entities.Contact;
import org.springframework.stereotype.Component;

@Component
public interface ContactMapper {

    public Contact toPureContact(Contact contact);

}
