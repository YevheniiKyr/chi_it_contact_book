package com.example.chi_it_contact_book.Mappers.ContactMappers;

import com.example.chi_it_contact_book.Entities.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContactMapperImpl implements ContactMapper{
    @Override
    public Contact toPureContact(Contact contact) {
        return new Contact(contact.getName(), contact.getUser());
    }
}
