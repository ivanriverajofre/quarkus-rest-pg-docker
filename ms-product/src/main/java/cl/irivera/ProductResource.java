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

import cl.irivera.model.Product;
import cl.irivera.repository.ProductRepository;
import java.util.List;

import cl.irivera.exception.CustomException;
import cl.irivera.exception.CustomExceptionHandler;

@Path("/product")
public class ProductResource {

    @Inject
    ProductRepository repository;

    @Path("/status")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String status() {
        return "OK";
    }

    @GET
    public List<Product> list() {
        return repository.listAll();
    }

    @Path("/{id:\\d+}")
    @GET
    public Product get(long id)  throws CustomException {
        Product c = repository.findById(id);
        if (c==null) throw new CustomException("NOT_FOUND");
        return c;
    }

    @POST
    @Transactional
    public Response post(Product p) {
        repository.persist(p);
        return Response.status(Status.CREATED).entity(p.getId()).build();
    }

    @PUT
    @Transactional
    public Response update(Product p) throws CustomException {
        Product c = repository.findById(p.getId());
        if (c==null) throw new CustomException("NOT_FOUND");
        c.setName(p.getName());
        c.setCategory(p.getCategory());
        repository.persist(c);
        return Response.status(Status.OK).entity("").build();  
    }

    @Path("/{id:\\d+}")
    @Transactional
    @DELETE
    public Response delete(long id) throws CustomException {
        Product c = repository.findById(id);
        if (c==null) throw new CustomException("NOT_FOUND");
        repository.delete(c);
        return Response.status(Status.OK).entity("").build();  
    }

    @Path("/search/{id:\\d+}")
    @GET
    public List<Product> search(long id) {
        return repository.list("category", id);
    }
}
