package com.example.chi_it_contact_book.DTO.requestsDTO;

import com.example.chi_it_contact_book.Annotations.Emails;
import com.example.chi_it_contact_book.Annotations.PhoneNumbers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContactDTO {

    @NotEmpty(message = "name cant be empty")
    private String name;

    @Emails
    private List<String> emails;
    @PhoneNumbers
    private List<String> phones;

}
