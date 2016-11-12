package org.codetaming.skillsmapper;

import org.codetaming.skillsmapper.services.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    private final static Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Autowired
    PersonService personService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
