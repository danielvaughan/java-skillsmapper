package org.codetaming.skillsmapper.controller;

import org.codetaming.skillsmapper.domain.Person;
import org.codetaming.skillsmapper.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService service;

    @RequestMapping(value="/{hash}", method=RequestMethod.GET)
    public @ResponseBody
    Person getByHash(@PathVariable(value = "hash") String hash) {
        return service.getByHash(hash);
    }
}
