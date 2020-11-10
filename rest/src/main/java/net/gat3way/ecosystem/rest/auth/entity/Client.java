package net.gat3way.ecosystem.rest.auth.entity;

import java.util.Objects;

public class Client {
    private int attribute1;
    private String attribute2;

    @Override
    public boolean equals(Object obj) {
        if (obj == null || Client.class != obj.getClass()) {
            return false;
        }

        // cast once
        Client that = (Client) obj;

        // compare attributes
        return (this.hashCode() == that.hashCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(attribute1, attribute2);

    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public int getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(int attribute1) {
        this.attribute1 = attribute1;
    }
}
