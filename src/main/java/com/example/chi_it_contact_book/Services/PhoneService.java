package com.example.chi_it_contact_book.Services;

import com.example.chi_it_contact_book.Repositories.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhoneService {

    private final PhoneRepository phoneRepository;
    public void deleteById(Long id){
        phoneRepository.deleteByIdNative(id);
    }
}
