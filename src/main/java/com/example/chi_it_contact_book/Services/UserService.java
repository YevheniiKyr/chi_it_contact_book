package com.example.chi_it_contact_book.Services;

import com.example.chi_it_contact_book.auth.User;
import com.example.chi_it_contact_book.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public Optional<User> getByName(String username){
        return userRepository.getByUsername(username);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> getById(Long id){
        return userRepository.findById(id);
    }

    public void deleteAll(){
        userRepository.deleteAll();
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    public User updateUser(User User){
        return userRepository.save(User);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
