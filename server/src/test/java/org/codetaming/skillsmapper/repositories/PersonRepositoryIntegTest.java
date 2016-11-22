package org.codetaming.skillsmapper.repositories;

import org.codetaming.skillsmapper.ProtoIntegrationTest;
import org.codetaming.skillsmapper.model.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PersonRepositoryIntegTest extends ProtoIntegrationTest {

    @Autowired
    private PersonRepository instance;
    
    @Test
    @DirtiesContext
    public void testFindByName() {
        Person result = instance.findByName(NAME);
        assertNotNull(result);
        assertEquals(NAME, result.getName());
        System.out.println(result.toString());
    }

    @Test
    @DirtiesContext
    public void testFindByHash() {
        Person result = instance.findByHash(HASH);
        assertNotNull(result);
        assertEquals(NAME, result.getName());
        assertEquals(HASH, result.getHash());
        System.out.println(result.toString());
    }
}

