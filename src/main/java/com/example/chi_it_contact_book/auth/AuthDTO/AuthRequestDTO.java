package com.example.chi_it_contact_book.auth.AuthDTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthRequestDTO {

    private String login;
    private String password;

}
