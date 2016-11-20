package org.codetaming.skillsmapper.client.services;

import org.codetaming.skillsmapper.client.model.Person;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public interface PersonService extends RestService {

    @GET
    @Path("http://localhost:9000/person/{hash}")
    void getByHash(@PathParam("hash") String hash, MethodCallback<Person> callback);

}
