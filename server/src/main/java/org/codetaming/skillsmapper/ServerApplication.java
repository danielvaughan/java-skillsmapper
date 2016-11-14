package org.codetaming.skillsmapper;

import org.codetaming.skillsmapper.services.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {

    private final static Logger LOGGER = LoggerFactory.getLogger(ServerApplication.class);

    @Autowired
    PersonService personService;

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

}
