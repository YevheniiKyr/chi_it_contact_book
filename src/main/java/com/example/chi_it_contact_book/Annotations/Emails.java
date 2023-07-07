package com.example.chi_it_contact_book.Annotations;

import com.example.chi_it_contact_book.Validators.EmailsValidator;
import com.example.chi_it_contact_book.Validators.PhoneNumbersValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailsValidator.class)
public @interface Emails {
    String message() default "Invalid email or duplicates";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
