package com.revaluper.rep_crud_project.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@Configuration
@ComponentScan(basePackages = "com.revaluper.rep_crud_project")
public class SpringConfiguration {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();

        source.setBasename("classpath:/messages/mesaages");
        source.setDefaultEncoding("UTF-8");
        source.setCacheSeconds(30);
        Locale.setDefault(Locale.KOREA);

        return source;

    }
}
