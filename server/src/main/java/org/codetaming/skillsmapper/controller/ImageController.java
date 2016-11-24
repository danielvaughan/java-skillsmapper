package org.codetaming.skillsmapper.controller;

import org.codetaming.skillsmapper.domain.ImageInfo;
import org.codetaming.skillsmapper.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    ImageService service;

    @RequestMapping(value="/{hash}", method=RequestMethod.GET)
    public @ResponseBody
    ImageInfo getByHash(@PathVariable(value = "hash") String hash) {
        return service.getByHash(hash);
    }
}
