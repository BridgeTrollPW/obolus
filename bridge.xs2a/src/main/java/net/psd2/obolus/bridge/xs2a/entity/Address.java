package net.psd2.obolus.bridge.xs2a.entity;

public class Address {
    private String streetName;
    private String buildingNumber;
    private String townName;
    private String postCode;
    private String country;

    public String getStreetName() {
        return streetName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

}
