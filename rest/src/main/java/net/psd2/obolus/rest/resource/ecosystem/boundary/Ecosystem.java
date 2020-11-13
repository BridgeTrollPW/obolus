package net.psd2.obolus.rest.resource.ecosystem.boundary;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/ecosystem")
public class Ecosystem {
    
    @GET
    @Path("/ping")
    public Response ping(){
        return Response.ok().build();
    }
}
