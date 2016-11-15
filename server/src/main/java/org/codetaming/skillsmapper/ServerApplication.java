package org.codetaming.skillsmapper;

import org.codetaming.skillsmapper.services.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class ServerApplication {

    private final static Logger LOGGER = LoggerFactory.getLogger(ServerApplication.class);

    @Autowired
    PersonService personService;

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // we have to enable CORS to make requests from other domains work
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
            }
        };
    }
}
