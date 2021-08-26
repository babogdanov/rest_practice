package com.practice.rest.person;


import com.practice.rest.address.Address;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;


@Entity
public class Person {
    @Id
    private UUID id;
    private String firstName,lastName;
    private int age;
    private String hobby;
    private Address address;

    public Person(){
        id = UUID.randomUUID();
        firstName = "John";
        lastName = "Doe";
        hobby = null;
        address = new Address();
    }
    public Person(String firstName, String lastName, int age, String hobby, Address address) {
        id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.hobby = hobby;
        this.address = address;
    }

    public UUID getId(){
        return id;
    }
    public void setId()
    {
        id = UUID.randomUUID();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
