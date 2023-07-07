package com.example.chi_it_contact_book.Controllers;

import com.example.chi_it_contact_book.DTO.requestsDTO.ContactDTO;
import com.example.chi_it_contact_book.Entities.Contact;
import com.example.chi_it_contact_book.Entities.Email;
import com.example.chi_it_contact_book.Entities.Phone;
import com.example.chi_it_contact_book.auth.User;
import com.example.chi_it_contact_book.Exceptions.AlreadyExistsException;
import com.example.chi_it_contact_book.Exceptions.ResourceNotFoundException;
import com.example.chi_it_contact_book.Mappers.ContactMappers.ContactMapperImpl;
import com.example.chi_it_contact_book.Services.ContactService;
import com.example.chi_it_contact_book.Services.EmailService;
import com.example.chi_it_contact_book.Services.PhoneService;
import com.example.chi_it_contact_book.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/contacts")
public class ContactController {


    private final EmailService emailService;

    private final PhoneService phoneService;
    private final ContactService contactService;
    private final ContactMapperImpl contactMapper;
    private final UserService userService;




    @GetMapping()
    public ResponseEntity<List<ContactDTO>> getContacts(@RequestParam(name = "user", required = false)  Long user_id) {
        if (user_id != null) {
            List<Contact> contacts = contactService.getByUserId(user_id);
            List<ContactDTO> contactsDTO = contactMapper.listToDTO(contacts);
            return ResponseEntity.ok().body(contactsDTO);
        } else {
            List<Contact> contacts = contactService.getAll();
            List<ContactDTO> contactsDTO = contactMapper.listToDTO(contacts);
            return ResponseEntity.ok().body(contactsDTO);

        }
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<ContactDTO> updateContact(@RequestBody @Valid ContactDTO contactDTO, @PathVariable Long id) {

        Contact newContact = contactMapper.toContact(contactDTO);
        Contact contactToUpdate = contactService.getById(id).orElseThrow(() -> new ResourceNotFoundException("Contact doesn't exist"));

        for(Email e : contactToUpdate.getEmails()){
            emailService.deleteById(e.getId());
        }
        for(Phone p : contactToUpdate.getPhones()){
            phoneService.deleteById(p.getId());
        }
//        contactToUpdate.setEmails(newContact.getEmails());
//        contactToUpdate.setName(newContact.getName());
//        contactToUpdate.setPhones(newContact.getPhones());
        newContact.setUser(contactToUpdate.getUser());
        newContact.setId(id);
        Contact updatedContact = contactService.updateContact(newContact);
        return ResponseEntity.ok(contactMapper.toDTO(updatedContact));

    }


    @Transactional
    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody ContactDTO contactDTO, @RequestParam("user") long user_id) {

        Contact contact = contactMapper.toContact(contactDTO);
        User user = userService.getById(user_id).orElseThrow(() -> new ResourceNotFoundException("User doesn't exist"));
        contact.setUser(user);

        List<String> userContactsName = contactService.getByUserId(user_id).stream().map(Contact::getName).collect(Collectors.toList());
        if(userContactsName.contains(contact.getName())) throw new AlreadyExistsException("Contact with this name already exists in contact list");

        Contact savedContact = contactService.createContact(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContact);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getById(@PathVariable Long id) {
        System.out.println("GET BU ID");
        return ResponseEntity.status(HttpStatus.CREATED).body(contactService.getById(id).orElseThrow(() -> new ResourceNotFoundException("Contact doesn't exist")));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        contactService.deleteById(id);
        return ResponseEntity.ok().body("object deleted: " + id);
    }
}
