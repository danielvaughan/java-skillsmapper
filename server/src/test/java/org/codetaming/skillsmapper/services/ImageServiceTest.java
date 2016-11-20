package org.codetaming.skillsmapper.services;

import org.codetaming.skillsmapper.MyNeo4jTestConfiguration;
import org.codetaming.skillsmapper.ProtoEmbeddedTest;
import org.codetaming.skillsmapper.domain.ImageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyNeo4jTestConfiguration.class)
@ActiveProfiles(profiles = "test")
public class ImageServiceTest extends ProtoEmbeddedTest {

    @Autowired
    private ImageService service;

    @Test
    @DirtiesContext
    public void testGetByHash() {
        ImageInfo imageInfo = service.getByHash(HASH);
        assertNotNull(imageInfo.getImageUrl());
    }

}
