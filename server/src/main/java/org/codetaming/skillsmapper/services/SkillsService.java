package org.codetaming.skillsmapper.services;

import org.codetaming.skillsmapper.domain.Person;
import org.codetaming.skillsmapper.domain.Tag;
import org.codetaming.skillsmapper.repositories.PersonRepository;
import org.codetaming.skillsmapper.repositories.TagRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class SkillsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SkillsService.class);

    @Autowired
    TagRepository tagRepository;

    @Autowired
    PersonRepository personRepository;


    public Set<Tag> getUsingByHash(String hash) {
        Person person = personRepository.findByHash(hash);
        return person.getUsing();
    }

    public Set<Tag> getInterestedInByHash(String hash) {
        Person person = personRepository.findByHash(hash);
        return person.getInterested();
    }

    public Set<Tag> getLearningByHash(String hash) {
        Person person = personRepository.findByHash(hash);
        return person.getLearning();
    }

    public Set<Tag> getUsedByHash(String hash) {
        Person person = personRepository.findByHash(hash);
        return person.getUsed();
    }
}
