package org.codetaming.skillsmapper.client.services;

import org.codetaming.skillsmapper.client.model.Hal;
import org.codetaming.skillsmapper.client.model.People;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("people")
public interface PeopleService extends RestService {

    @GET
    void getPeople(MethodCallback<Hal<People>> callback);

    @GET
    @Path("/search/findWithProfile")
    void getPeopleWithProfile(MethodCallback<Hal<People>> callback);

}

