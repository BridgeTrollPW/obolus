package net.gat3way.ecosystem.rest.middleware.hmac.boundary;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.ServiceUnavailableException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import net.gat3way.ecosystem.rest.middleware.hmac.control.APITokenService;

@Provider
@HMACValidation
public class HMACMiddleware implements ContainerRequestFilter {
    private static final String HTTP_TOKEN = "token";
    private static final String HTTP_HMAC = "hmac";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        if (requestContext.getHeaderString(HTTP_TOKEN) == null || requestContext.getHeaderString(HTTP_HMAC) == null) {
            throw new BadRequestException("token or hmac is missing");
        }
        if (requestContext.hasEntity()) {
            try {
                APITokenService apiTokenService = new APITokenService();
                
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
                messageDigest.update( requestContext.getEntityStream().readAllBytes());
            } catch (NoSuchAlgorithmException e) {
                throw new ServiceUnavailableException(e.getMessage());
            }
        }
    }
}
