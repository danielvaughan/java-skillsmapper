package org.codetaming.skillsmapper.client.services;

import org.codetaming.skillsmapper.client.model.ImageInfo;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("image")
public interface ImageService extends RestService {

    @GET
    @Path("{hash}")
    void getByHash(@PathParam("hash") String hash, MethodCallback<ImageInfo> callback);

}
