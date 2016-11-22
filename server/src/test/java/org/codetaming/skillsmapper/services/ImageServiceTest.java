package org.codetaming.skillsmapper.services;

import org.codetaming.skillsmapper.ProtoEmbeddedTest;
import org.codetaming.skillsmapper.domain.ImageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.assertNotNull;

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
