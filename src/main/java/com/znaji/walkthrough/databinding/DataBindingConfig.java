package com.znaji.walkthrough.databinding;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.FormattingConversionService;

@Configuration
@ComponentScan()
public class DataBindingConfig {

    @Bean
    public ConversionService conversionService() {
        FormattingConversionService conversionService = new FormattingConversionService();
        conversionService.addConverter(new TagConverter());
        return conversionService;
    }
}
