package org.codetaming.skillsmapper.services;

import org.codetaming.skillsmapper.ProtoEmbeddedTest;
import org.codetaming.skillsmapper.domain.Tag;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Set;

import static junit.framework.TestCase.assertFalse;

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
