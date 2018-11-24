package com.belljava.advanced.customer.springbootcustomer.model;

public class Customer {

    String name;

    String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
