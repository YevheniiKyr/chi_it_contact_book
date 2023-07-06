package com.example.chi_it_contact_book.Services;

import com.example.chi_it_contact_book.Repositories.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {


    private final EmailRepository emailRepository;
    public void deleteById(Long id){
        System.out.println("WE ARE HERE" );
         emailRepository.deleteByIdNative(id);
    }
}
