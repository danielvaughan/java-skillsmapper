package org.codetaming.skillsmapper.client.services;

import org.codetaming.skillsmapper.client.model.Hal;
import org.codetaming.skillsmapper.client.model.People;
import org.codetaming.skillsmapper.client.model.Person;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("people")
public interface PeopleService extends RestService {

    @GET
    void getPeople(MethodCallback<Hal<People>> callback);

    @GET
    @Path("/{id}")
    void getPerson(@PathParam("id") Long id, MethodCallback<Person> callback);

    @GET
    @Path("/search/findWithProfile")
    void getPeopleWithProfile(MethodCallback<Hal<People>> callback);

}

