package net.psd2.obolus.rest.resource.pis.boundary;

import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import net.psd2.obolus.rest.resource.pis.entity.SinglePaymentInitiationResponse;

@Path("/payments/{payment-product}")
public class SinglePlaymentResource {

    @POST
    public SinglePaymentInitiationResponse initiate() {
        SinglePaymentInitiationResponse sInitiationResponse = new SinglePaymentInitiationResponse();
        sInitiationResponse.setPaymentId(UUID.randomUUID().toString());
        return sInitiationResponse;
    }

    @GET
    @Path("/{payment-id}")
    public Response fetch() {
        return null;
    }

    @GET
    @Path("/{payment-id}/status")
    public Response status() {
        return null;
    }
}
