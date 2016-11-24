package org.codetaming.skillsmapper.services;

import org.codetaming.skillsmapper.ProtoEmbeddedTest;
import org.codetaming.skillsmapper.domain.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import static junit.framework.TestCase.assertTrue;

public class PersonServiceTest extends ProtoEmbeddedTest {

    @Autowired
    private PersonService service;

    @Test
    @DirtiesContext
    public void testGetInterestedInByHash() {
        Iterable<Person> people = service.getPeopleWithProfiles();
        assertTrue(people.iterator().hasNext());
    }
}
