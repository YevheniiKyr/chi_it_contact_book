package com.example.chi_it_contact_book.auth;

import com.example.chi_it_contact_book.auth.AuthDTO.AuthRequestDTO;
import com.example.chi_it_contact_book.auth.AuthDTO.UserRegistrationDTO;
import com.example.chi_it_contact_book.auth.AuthDTO.AuthResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody @Valid UserRegistrationDTO userRegistrationDTO){
        return ResponseEntity.ok(authService.register(userRegistrationDTO));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponseDTO> authenticate(@RequestBody AuthRequestDTO authRequestDTO){
        return ResponseEntity.ok(authService.authenticate(authRequestDTO));
    }
}
