package com.example.chi_it_contact_book.Mappers.ContactMappers;

import com.example.chi_it_contact_book.DTO.requestsDTO.ContactDTO;
import com.example.chi_it_contact_book.Entities.Contact;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ContactMapper {

      Contact toContact(ContactDTO contactDTO);
      ContactDTO toDTO(Contact contact);

     List<ContactDTO> listToDTO (List<Contact> contacts);

}
