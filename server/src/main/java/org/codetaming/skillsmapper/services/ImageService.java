package org.codetaming.skillsmapper.services;

import org.codetaming.skillsmapper.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@Transactional
@RequestMapping("/image")
public class ImageService {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    String getByHash(@RequestParam(value = "hash", required = true) String hash) {
        return personRepository.findByHash(hash).getImageUrl();
    }

}
