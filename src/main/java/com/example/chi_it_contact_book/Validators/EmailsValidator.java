package com.example.chi_it_contact_book.Validators;

import com.example.chi_it_contact_book.Annotations.Emails;
import com.example.chi_it_contact_book.Annotations.PhoneNumbers;
import com.example.chi_it_contact_book.utils.ListUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;


public class EmailsValidator implements ConstraintValidator<Emails, List<String>> {

    private static final String EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    @Override
    public boolean isValid(List<String> emails, ConstraintValidatorContext constraintValidatorContext) {
        if(emails == null) return false;
        if(ListUtils.hasDuplicateElements(emails)) {

            return false;
        }
        for(String email: emails){
            if (!email.matches(EMAIL_PATTERN)) return false;
        }
        return true;

    }


}