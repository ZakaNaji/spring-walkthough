package com.znaji.walkthrough.databinding;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        var form = (UserForm) target;
        if (form.getAge() < 20 || form.getAge() > 60) {
            errors.rejectValue("age", "form.code", "Age can't be less than 20 or more tha 60");
        }
    }
}
