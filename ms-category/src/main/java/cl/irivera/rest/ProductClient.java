package cl.irivera.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import java.util.List;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/product")
@RegisterRestClient(configKey = "productos")
public interface ProductClient {

    @GET
    @Path("/search/{category}")
    @Produces(MediaType.APPLICATION_JSON)
    List<Product> search(@PathParam("category") Long category);

    @PUT
    Response update(Product p);

}

