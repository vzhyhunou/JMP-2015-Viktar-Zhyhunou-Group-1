package model;

import javax.persistence.Embeddable;

/**
 * Created by Natallia_Rakitskaya.
 */
@Embeddable
public class Address {
    private String street;
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
