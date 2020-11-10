package net.gat3way.ecosystem.rest.middleware.hmac.control;

import javax.ws.rs.ServiceUnavailableException;

import net.gat3way.ecosystem.foundation.service.rest.boundary.APITokenServiceProvider;
import net.gat3way.ecosystem.foundation.service.rest.entity.APIToken;

public class APITokenService implements APITokenServiceProvider {
    @Override
    public APIToken fetch(int id) {
        throw new ServiceUnavailableException();
    }

    @Override
    public APIToken fetch(String hash) {
        APIToken apiToken = new APIToken();
        apiToken.setHash("token");
        apiToken.setSecret("secret");
        return apiToken;
    }

}
