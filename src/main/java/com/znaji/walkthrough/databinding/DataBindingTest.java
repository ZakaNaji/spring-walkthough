package com.znaji.walkthrough.databinding;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class DataBindingTest {

    public static void main(String[] args) {
        UserForm form = new UserForm();
        DataBinder binder = new DataBinder(form);
        Map<String, String> map = Map.of(
                "name", "Zakaria",
                "email", "znaji@gmail.com",
                "age", "ten",
                "date", "2025/10/10"
        );
        binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public String getAsText() {
                return ((LocalDate)getValue()).toString();
            }

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy/MM/dd")));
            }
        });
        binder.bind(new MutablePropertyValues(map));
        BindingResult result = binder.getBindingResult();
        System.out.println(form.getName());
        System.out.println(form.getEmail());
        System.out.println(form.getDate());
        System.out.println(result.getErrorCount());
        //System.out.println(result.getFieldError("date").getDefaultMessage());
    }
}
