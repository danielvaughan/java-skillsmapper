package org.codetaming.skillsmapper.repositories;

import org.codetaming.skillsmapper.MyNeo4jConfiguration;
import org.codetaming.skillsmapper.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyNeo4jConfiguration.class)
@ActiveProfiles(profiles = "test")
public class PersonRepositoryIntegTest {

    private static final String NAME = "Daniel Vaughan";
    private static final String HASH = "b4f06f0d4337c3af720f37ef402c1ad9d6f3058f";

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

