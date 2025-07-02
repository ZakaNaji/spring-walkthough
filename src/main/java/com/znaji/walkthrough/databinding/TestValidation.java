package com.znaji.walkthrough.databinding;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

public class TestValidation {
    public static void main(String[] args) {
        try (var ctx = new AnnotationConfigApplicationContext(DataBindingConfig.class)) {
            UserService userService = ctx.getBean(UserService.class);

            String msg= ctx.getMessage("user.name", null, Locale.US);
            System.out.println(msg);

            var user = new UserForm();
            user.setName("ZakariaNaji");
            user.setAge(25);

            userService.printUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
