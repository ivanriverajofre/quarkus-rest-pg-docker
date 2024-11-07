package cl.irivera;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import cl.irivera.model.Category;
import cl.irivera.repository.CategoryRepository;
import java.util.List;

import cl.irivera.exception.CustomException;
import cl.irivera.exception.CustomExceptionHandler;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import cl.irivera.rest.ProductClient;
import cl.irivera.rest.Product;

@Path("/category")
public class CategoryResource {

    @Inject
    CategoryRepository repository;

    @RestClient
    ProductClient client;

    @Path("/status")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String status() {
        return "OK";
    }

    @GET
    public List<Category> list() {
        return repository.listAll();
    }

    @Path("/{id:\\d+}")
    @GET
    public Category get(long id)  throws CustomException {
        Category c = repository.findById(id);
        if (c==null) throw new CustomException("NOT_FOUND");
        return c;
    }

    @POST
    @Transactional
    public Response post(Category p) {
        repository.persist(p);
        return Response.status(Status.CREATED).entity(p.getId()).build();
    }

    @PUT
    @Transactional
    public Response update(Category p) throws CustomException {
        Category c = repository.findById(p.getId());
        if (c==null) throw new CustomException("NOT_FOUND");
        c.setName(p.getName());
        repository.persist(c);
        return Response.status(Status.OK).entity("").build();  
    }

    @Path("/{id:\\d+}")
    @Transactional
    @DELETE
    public Response delete(long id) throws CustomException {
        Category c = repository.findById(id);
        if (c==null) throw new CustomException("NOT_FOUND");

        /* recupero todos los productos y los dejo sin categoria */
        List<Product> productos = client.search(id);
        for (Product p : productos) {
            p.setCategory(0);
            client.update(p);
        }

        repository.delete(c);
        return Response.status(Status.OK).entity("").build();  
    }

}









/*
import org.eclipse.microprofile.rest.client.inject.RestClient;

*/