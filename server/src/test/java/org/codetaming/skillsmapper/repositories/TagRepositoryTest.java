package org.codetaming.skillsmapper.repositories;

import org.codetaming.skillsmapper.MyNeo4jTestConfiguration;
import org.codetaming.skillsmapper.ProtoEmbeddedTest;
import org.codetaming.skillsmapper.domain.Tag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyNeo4jTestConfiguration.class)
@ActiveProfiles(profiles = "test")
public class TagRepositoryTest extends ProtoEmbeddedTest {

    @Test
    @DirtiesContext
    public void testFindByName() {
        Tag result = tagRepository.findByName(TAG_NAME);
        assertNotNull(result);
        assertEquals(TAG_NAME, result.getName());
    }

}
