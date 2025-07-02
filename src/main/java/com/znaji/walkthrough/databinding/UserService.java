package com.znaji.walkthrough.databinding;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class UserService {

    public void printUser(@Valid UserForm userForm) {
        System.out.println(userForm);
    }
}
