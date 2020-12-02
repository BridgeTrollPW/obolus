package net.psd2.obolus.rest.middleware;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import net.psd2.obolus.bridge.xs2a.entity.MessageCode;
import net.psd2.obolus.bridge.xs2a.entity.TPPMessageInformation;

@Provider
public class ContentTypeFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String contentType = requestContext.getHeaderString("content-type");
        if (contentType == null || "".equals(contentType) || !contentType.equals("application/json")) {
            TPPMessageInformation tppMessageInformation = new TPPMessageInformation();
            tppMessageInformation.setCategory(TPPMessageInformation.Category.WARNING);
            tppMessageInformation.setCode(MessageCode.FORMAT_ERROR);
            tppMessageInformation.setPath(requestContext.getUriInfo().getRequestUri().toString());
            tppMessageInformation.setText("Obolus only accepts application/json as content-type");

            requestContext
                    .abortWith(Response.status(tppMessageInformation.getCode()).entity(tppMessageInformation).build());
        }
    }

}
