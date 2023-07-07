package com.example.chi_it_contact_book.auth.AuthDTO;

import com.example.chi_it_contact_book.Annotations.Emails;
import com.example.chi_it_contact_book.Annotations.PhoneNumbers;
import com.example.chi_it_contact_book.Entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRegistrationDTO {
    @NotEmpty(message = "login cant be empty")
    @Length(min= 3,max = 32)
    private String login;

    @NotEmpty(message = "password cant be empty")
    @Length(min= 3,max = 32)
    private String password;
    private Role role;

}
