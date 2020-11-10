package net.gat3way.ecosystem.foundation.service.rest.entity;

import java.util.Date;

public class APIToken {
    private int id;
    private String hash;
    private String secret;
    private Date createdAt;
    private Date updatedAt;
    private boolean disabled;

    public int getId() {
        return id;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public void setId(int id) {
        this.id = id;
    }

}
