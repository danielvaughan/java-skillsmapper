package org.codetaming.skillsmapper.client.services;

import org.codetaming.skillsmapper.client.model.GroupsWrapper;
import org.codetaming.skillsmapper.client.model.PeopleWrapper;
import org.codetaming.skillsmapper.client.model.Person;
import org.codetaming.skillsmapper.client.model.TagsWrapper;
import org.codetaming.skillsmapper.client.model.TitlesWrapper;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("people")
public interface PeopleService extends RestService {

    @GET
    void getPeople(MethodCallback<PeopleWrapper> callback);

    @GET
    @Path("/{id}")
    void getPerson(@PathParam("id") String id, MethodCallback<Person> callback);

    @GET
    @Path("/{id}/groups")
    void getGroups(@PathParam("id") String id, MethodCallback<GroupsWrapper> callback);

    @GET
    @Path("/{id}/titles")
    void getTitles(@PathParam("id") String id, MethodCallback<TitlesWrapper> callback);

    @GET
    @Path("/search/findWithProfile")
    void getPeopleWithProfile(MethodCallback<PeopleWrapper> callback);

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

