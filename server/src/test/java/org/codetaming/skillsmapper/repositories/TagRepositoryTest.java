package org.codetaming.skillsmapper.repositories;

import org.codetaming.skillsmapper.ProtoEmbeddedTest;
import org.codetaming.skillsmapper.model.Tag;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TagRepositoryTest extends ProtoEmbeddedTest {

    @Test
    @DirtiesContext
    public void testFindByName() {
        Tag result = tagRepository.findByName(TAG_NAME);
        assertNotNull(result);
        assertEquals(TAG_NAME, result.getName());
    }

}
