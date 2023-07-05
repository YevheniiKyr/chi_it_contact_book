package com.example.chi_it_contact_book.Controllers;

import com.example.chi_it_contact_book.Entities.Contact;
import com.example.chi_it_contact_book.Entities.Email;
import com.example.chi_it_contact_book.Entities.Phone;
import com.example.chi_it_contact_book.Entities.User;
import com.example.chi_it_contact_book.Exceptions.ResourceNotFoundException;
import com.example.chi_it_contact_book.Services.ContactService;
import com.example.chi_it_contact_book.Services.EmailService;
import com.example.chi_it_contact_book.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class ContactController {

    @Autowired
    private EmailService emailService;
    @Autowired
    private ContactService contactService;

    @Autowired
    private UserService userService;
    @GetMapping("/contacts")
    public ResponseEntity<List<Contact>> getContacts() {
        return ResponseEntity.ok().body(contactService.getAll());
    }

    @Transactional
    @PostMapping("/contacts")
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact , @RequestParam ("user") long user_id ) {

        System.out.println(user_id);
      //  long user_id = contact.getUser().getId();
        User user = userService.getById(user_id).orElseThrow(() -> new ResourceNotFoundException("User doesn't exist"));
        contact.setUser(user);
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAA" + contact.getEmails());
        Set<Email> emails = contact.getEmails().stream()
                .map(email -> {
                    Email emailEntity = new Email();
                    emailEntity.setEmail(email.getEmail());
                    emailEntity.setContact(contact);
                    return emailEntity;
                })
                .collect(Collectors.toSet());
        contact.setEmails(emails);

        Set<Phone> phones = contact.getPhones().stream()
                .map(phone -> {
                    Phone phoneEntity = new Phone();
                    phoneEntity.setNumber(phone.getNumber());
                    phoneEntity.setContact(contact);
                    return phoneEntity;
                })
                .collect(Collectors.toSet());
        contact.setPhones(phones);

        Contact savedContact = contactService.createContact(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContact);

    }

    @GetMapping("/contacts/{id}")
    public ResponseEntity<Contact> getById(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.CREATED).body(contactService.getById(id).orElseThrow(() -> new ResourceNotFoundException("Contact doesn't exist")));

    }


    @PutMapping("/contacts/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        contact.setId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(contactService.updateContact(contact));

    }
}
