package net.psd2.obolus.bridge.xs2a.entity;

public class Remittance {
    private String reference;
    private String referenceType;
    private String referenceIssuer;

    public String getReferenceIssuer() {
        return referenceIssuer;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }

    public void setReferenceIssuer(String referenceIssuer) {
        this.referenceIssuer = referenceIssuer;
    }
}
