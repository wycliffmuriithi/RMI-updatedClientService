package com.rmi.clientservice.apiendpoints.models.request;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

public class AddtoyRequest implements Serializable {
    String username;
    String password;
    String toyname;
    double toycost;
    int units;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToyname() {
        return toyname;
    }

    public void setToyname(String toyname) {
        this.toyname = toyname;
    }

    public double getToycost() {
        return toycost;
    }

    public void setToycost(double toycost) {
        this.toycost = toycost;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            System.err.println(e);
        }
        return null;
    }
}
