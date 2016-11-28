package org.codetaming.skillsmapper.client.services;

import org.codetaming.skillsmapper.client.model.Groups;
import org.codetaming.skillsmapper.client.model.Hal;
import org.codetaming.skillsmapper.client.model.People;
import org.codetaming.skillsmapper.client.model.Person;
import org.codetaming.skillsmapper.client.model.TagsWrapper;
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
    void getPerson(@PathParam("id") String id, MethodCallback<Person> callback);

    @GET
    @Path("/{id}/groups")
    void getGroups(@PathParam("id") String id, MethodCallback<Hal<Groups>> callback);

    @GET
    @Path("/search/findWithProfile")
    void getPeopleWithProfile(MethodCallback<Hal<People>> callback);

    @GET
    @Path("/{id}/interested")
    void getInterested(@PathParam("id") String id, MethodCallback<TagsWrapper> callback);

    @GET
    @Path("/{id}/learning")
    void getLearning(@PathParam("id") String id, MethodCallback<TagsWrapper> callback);

    @GET
    @Path("/{id}/using")
    void getUsing(@PathParam("id") String id, MethodCallback<TagsWrapper> callback);

    @GET
    @Path("/{id}/used")
    void getUsed(@PathParam("id") String id, MethodCallback<TagsWrapper> callback);
}

