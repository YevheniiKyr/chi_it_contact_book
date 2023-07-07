package com.example.chi_it_contact_book.Validators;

import com.example.chi_it_contact_book.Annotations.PhoneNumbers;
import com.example.chi_it_contact_book.utils.ListUtils;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Set;
@RequiredArgsConstructor
public class PhoneNumbersValidator implements ConstraintValidator<PhoneNumbers, List<String>> {

    private static final String PHONE_NUMBER_PATTERN = "\\+\\d{10}";

    @Override
    public boolean isValid(List<String> numbers, ConstraintValidatorContext constraintValidatorContext) {
        if(numbers == null) return false;
        if(ListUtils.hasDuplicateElements(numbers)) return false;
        for(String number: numbers){
            if (!number.matches(PHONE_NUMBER_PATTERN)) return false;
        }
        return true;

    }


}
