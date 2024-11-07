package cl.irivera.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
 
@Provider
public class CustomExceptionHandler implements ExceptionMapper<CustomException> 
{
  @Override
  public Response toResponse(CustomException exception) 
  {
    if (exception.getMessage().equals("NOT_FOUND"))
        return Response.status(Status.NOT_FOUND).entity(exception.getMessage()).build();  
    return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();  
  }
}