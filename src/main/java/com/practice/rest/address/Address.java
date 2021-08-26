package com.practice.rest.address;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Embeddable
@Entity
public class Address {
    @Id
    private UUID id;
    private String country, city, street;
    private int number;

    public Address(){
        id = UUID.randomUUID();
        country = "Denmark";
        city = "Atlantis";
        street = "Opulchenska";
        number = 5;
    }
    public Address(String country, String city, String street, int number) {
        id = UUID.randomUUID();
        this.country = country;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public UUID getId(){
        return id;
    }
    public void setId()
    {
        id = UUID.randomUUID();
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
