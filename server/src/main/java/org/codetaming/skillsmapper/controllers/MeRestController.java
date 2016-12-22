package org.codetaming.skillsmapper.controllers;

import org.codetaming.skillsmapper.domain.Person;
import org.codetaming.skillsmapper.repositories.PersonRepository;
import org.codetaming.skillsmapper.services.UsernameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/me")
public class MeRestController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private UsernameService usernameService;

    @RequestMapping(method = RequestMethod.GET)
    public Person getMe() throws Exception {
        String email = usernameService.getUsername();
        return personRepository.findByEmail(email);
    }
}
