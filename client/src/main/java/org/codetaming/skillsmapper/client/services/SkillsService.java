package org.codetaming.skillsmapper.client.services;

import org.codetaming.skillsmapper.client.model.Tag;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("skills")
public interface SkillsService extends RestService {

    @GET
    @Path("interested/{hash}")
    void getInterestedInByHash(@PathParam("hash") String hash, MethodCallback<Set<Tag>> callback);

    @GET
    @Path("learning/{hash}")
    void getLearningInByHash(@PathParam("hash") String hash, MethodCallback<Set<Tag>> callback);

    @GET
    @Path("using/{hash}")
    void getUsingInByHash(@PathParam("hash") String hash, MethodCallback<Set<Tag>> callback);

    @GET
    @Path("used/{hash}")
    void getUsedInByHash(@PathParam("hash") String hash, MethodCallback<Set<Tag>> callback);
}
