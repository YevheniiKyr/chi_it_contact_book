package com.example.chi_it_contact_book.Mappers.ContactMappers;

import com.example.chi_it_contact_book.DTO.requestsDTO.ContactDTO;
import com.example.chi_it_contact_book.Entities.Contact;
import com.example.chi_it_contact_book.Entities.Email;
import com.example.chi_it_contact_book.Entities.Phone;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ContactMapperImpl implements ContactMapper{

   // private final UserService userService;
    @Override
    public Contact toContact(ContactDTO contactDTO) {

        Contact contact = new Contact();
        contact.setName(contactDTO.getName());
    //    User user = userService.getById(user_id).orElseThrow(() -> new ResourceNotFoundException("User doesn't exist"));
     //   contact.setUser(user);

        Set<Email> emails = contactDTO.getEmails().stream()
                .map(email -> {
                    Email emailEntity = new Email();
                    emailEntity.setEmail(email);
                    emailEntity.setContact(contact);
                    return emailEntity;
                })
                .collect(Collectors.toSet());
        contact.setEmails(emails);

        Set<Phone> phones = contactDTO.getPhones().stream()
                .map(phone -> {
                    Phone phoneEntity = new Phone();
                    phoneEntity.setNumber(phone);
                    phoneEntity.setContact(contact);
                    return phoneEntity;
                })
                .collect(Collectors.toSet());
        contact.setPhones(phones);
        return contact;
    }

    @Override
    public ContactDTO toDTO(Contact contact) {

        ContactDTO contactDTO = new ContactDTO();

        List<String> emails = contact.getEmails().stream()
                .map(email -> {
                    String emailString = email.getEmail();
                    return emailString;
                })
                .collect(Collectors.toList());

        List<String> phones = contact.getPhones().stream()
                .map(phone -> {
                    String numberString = phone.getNumber();
                    return numberString;
                })
                .collect(Collectors.toList());

        contactDTO.setEmails(emails);
        contactDTO.setPhones(phones);
        contactDTO.setName(contact.getName());


        return contactDTO;
    }

    @Override
    public List<ContactDTO> listToDTO(List<Contact> contacts) {
        List<ContactDTO> contactsDTO = contacts.stream().map(this::toDTO).collect(Collectors.toList());
        return contactsDTO;
    }
}
