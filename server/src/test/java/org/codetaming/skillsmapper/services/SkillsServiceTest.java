package org.codetaming.skillsmapper.services;

import org.codetaming.skillsmapper.MyNeo4jTestConfiguration;
import org.codetaming.skillsmapper.ProtoEmbeddedTest;
import org.codetaming.skillsmapper.domain.Tag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

import static junit.framework.TestCase.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyNeo4jTestConfiguration.class)
@ActiveProfiles(profiles = "test")
public class SkillsServiceTest extends ProtoEmbeddedTest {

    @Autowired
    private SkillsService service;

    @Test
    @DirtiesContext
    public void testGetInterestedInByHash() {
        Set<Tag> tags = service.getInterestedInByHash(HASH);
        assertFalse(tags.isEmpty());
    }

    @Test
    @DirtiesContext
    public void testGetLearningByHash() {
        Set<Tag> tags = service.getLearningByHash(HASH);
        assertFalse(tags.isEmpty());
    }

    @Test
    @DirtiesContext
    public void testGetUsingByHash() {
        Set<Tag> tags = service.getUsingByHash(HASH);
        assertFalse(tags.isEmpty());
    }

    @Test
    @DirtiesContext
    public void testGetUsedByHash() {
        Set<Tag> tags = service.getUsedByHash(HASH);
        assertFalse(tags.isEmpty());
    }
}
