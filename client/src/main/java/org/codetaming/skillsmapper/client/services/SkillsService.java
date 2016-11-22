package org.codetaming.skillsmapper.client.services;

import org.codetaming.skillsmapper.client.model.Tag;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Set;

public interface SkillsService extends RestService {

    @GET
    @Path("http://localhost:9000/skills/interested/{hash}")
    void getInterestedInByHash(@PathParam("hash") String hash, MethodCallback<Set<Tag>> callback);
}
