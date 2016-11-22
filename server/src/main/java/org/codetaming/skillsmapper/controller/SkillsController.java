package org.codetaming.skillsmapper.controller;

import org.codetaming.skillsmapper.model.Tag;
import org.codetaming.skillsmapper.services.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/skills")
public class SkillsController {

    @Autowired
    SkillsService service;

    @RequestMapping(value="/interested/{hash}", method=RequestMethod.GET)
    public @ResponseBody
    Set<Tag> getInterestedInByHash(@PathVariable(value = "hash") String hash) {
        return service.getInterestedInByHash(hash);
    }

    @RequestMapping(value="/learning/{hash}", method=RequestMethod.GET)
    public @ResponseBody
    Set<Tag> getLearningByHash(@PathVariable(value = "hash") String hash) {
        return service.getLearningByHash(hash);
    }

    @RequestMapping(value="/using/{hash}", method=RequestMethod.GET)
    public @ResponseBody
    Set<Tag> getUsingByHash(@PathVariable(value = "hash") String hash) {
        return service.getUsingByHash(hash);
    }

    @RequestMapping(value="/used/{hash}", method=RequestMethod.GET)
    public @ResponseBody
    Set<Tag> getUsedByHash(@PathVariable(value = "hash") String hash) {
        return service.getUsedByHash(hash);
    }
}
