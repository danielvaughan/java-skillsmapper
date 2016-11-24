package org.codetaming.skillsmapper.services;

import org.codetaming.skillsmapper.domain.Person;
import org.codetaming.skillsmapper.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class PersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageService.class);

    @Autowired
    PersonRepository personRepository;

    public Person getByHash(String hash) {
        Person person = personRepository.findByHash(hash);
        return person;
    }

    public List<Person> getPeopleWithProfiles() {
        return toList(personRepository.findWithProfile());
    }

    public static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }
}
