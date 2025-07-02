package com.znaji.walkthrough.databinding;

import org.springframework.core.convert.converter.Converter;

import java.util.Arrays;
import java.util.List;

public class TagConverter implements Converter<String, List<String>> {
    @Override
    public List<String> convert(String source) {
        return Arrays.stream(source.split(","))
                .map(String::trim)
                .toList();
    }
}
