package org.codetaming.skillsmapper.repositories;

import org.codetaming.skillsmapper.ProtoEmbeddedTest;
import org.codetaming.skillsmapper.model.Person;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PersonRepositoryTest extends ProtoEmbeddedTest {

    @Test
    @DirtiesContext
    public void testFindByName() {
        Person result = personRepository.findByName(NAME);
        assertNotNull(result);
        assertEquals(NAME, result.getName());
    }

    @Test
    @DirtiesContext
    public void testFindByHash() {
        Person result = personRepository.findByHash(HASH);
        assertNotNull(result);
        assertEquals(NAME, result.getName());
    }
}
