package resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Customer;
import org.eclipse.jetty.http.HttpStatus;
import service.CustomerService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by sallu on 10/30/2016.
 */
@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {
    private static ObjectMapper mapper = new ObjectMapper();
    @GET
    @Path("/{id}")
    public Response getCustomer(@PathParam("id") String id){
        Customer customer;
        try {
            customer = CustomerService.INSTANCE.getCustomer(id);
        } catch (Exception e) {
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).entity(e.getMessage()).build();
        }

        return Response.status(200).entity(customer).build();
    }

    @PUT
    @Path("/{id}")
    public Response UpdateCustomer(@PathParam("id") String id,
                                   @Valid Customer customer){
        try {
            CustomerService.INSTANCE.updateCustomer(id, customer);
        } catch (Exception e) {
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).entity(e.getMessage()).build();
        }
        return Response.status(HttpStatus.OK_200).build();

    }

    @POST
    public Response postCustomer(@Valid Customer customer){
        String id ;
        try {
            id = CustomerService.INSTANCE.buildCustomer(customer);
        } catch (Exception e) {
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).entity(e.getMessage()).build();
        }
        return Response.status(HttpStatus.CREATED_201).entity("{\"id\":\""+id+"\"}").build();

    }
}
