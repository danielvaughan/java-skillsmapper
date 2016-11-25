package org.codetaming.skillsmapper.services;

import org.codetaming.skillsmapper.domain.Person;
import org.codetaming.skillsmapper.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Person getByHash(String hash) {
        return personRepository.findByHash(hash);
    }

    public List<Person> getPeopleWithProfiles() {
        return toList(personRepository.findWithProfile());
    }

    public static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }
}
