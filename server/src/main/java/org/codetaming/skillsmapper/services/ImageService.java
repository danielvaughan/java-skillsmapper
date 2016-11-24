package org.codetaming.skillsmapper.services;

import org.codetaming.skillsmapper.domain.ImageInfo;
import org.codetaming.skillsmapper.domain.Person;
import org.codetaming.skillsmapper.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageService.class);

    @Autowired
    PersonRepository personRepository;

    public ImageInfo getByHash(String hash) {
        Person person = personRepository.findByHash(hash);
        ImageInfo imageInfo = new ImageInfo();
        imageInfo.setName(person.getName());
        imageInfo.setImageUrl(person.getImageUrl() == null ? "http://common.gcscc.site/img/silhouette.png" : person.getImageUrl());
        return imageInfo;
    }

}
