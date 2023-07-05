package com.example.chi_it_contact_book.Services;

import com.example.chi_it_contact_book.Entities.Contact;
import com.example.chi_it_contact_book.Repositories.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactService {


    private final ContactRepository contactRepository;




    public List<Contact> getAll(){
        return contactRepository.findAll();
    }

    public Optional<Contact> getById(Long id){
        return contactRepository.findById(id);
    }

    public void deleteAll(){
        contactRepository.deleteAll();
    }

    public void deleteById(Long id){
        contactRepository.deleteById(id);
    }
    public Contact createContact(Contact contact){
        return contactRepository.save(contact);
    }

    public Contact updateContact(Contact contact){
        return contactRepository.save(contact);
    }

}
