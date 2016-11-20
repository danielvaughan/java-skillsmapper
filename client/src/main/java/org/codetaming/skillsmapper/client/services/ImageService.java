package org.codetaming.skillsmapper.client.services;

import org.codetaming.skillsmapper.client.model.ImageInfo;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public interface ImageService extends RestService {

    @GET
    @Path("http://localhost:9000/image/{hash}")
    void getImageByHash(@PathParam("hash") String hash, MethodCallback<ImageInfo> callback);

}
