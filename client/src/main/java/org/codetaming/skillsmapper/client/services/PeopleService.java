package org.codetaming.skillsmapper.client.services;

import org.codetaming.skillsmapper.client.model.Hal;
import org.codetaming.skillsmapper.client.model.People;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("http://localhost:9000/people")
public interface PeopleService extends RestService {

    @GET
    void getPeople(MethodCallback<Hal<People>> callback);

}
