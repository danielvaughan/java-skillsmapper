package org.codetaming.skillsmapper.services;

import org.codetaming.skillsmapper.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonService {

    @Autowired
    PersonRepository personRepository;

}
