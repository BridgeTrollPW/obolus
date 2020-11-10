package net.gat3way.ecosystem.foundation.service.rest.boundary;

import net.gat3way.ecosystem.foundation.service.rest.entity.APIToken;

public interface APITokenServiceProvider {
    APIToken fetch(int id);
    APIToken fetch(String hash);
}
