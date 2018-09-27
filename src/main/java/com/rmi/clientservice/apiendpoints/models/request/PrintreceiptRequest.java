package com.rmi.clientservice.apiendpoints.models.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rmi.clientservice.apiendpoints.models.Toy;

import java.util.List;

public class PrintreceiptRequest {
    String username;
    String password;
    List<Toy> toysList;

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

    public List<Toy> getToysList() {
        return toysList;
    }

    public void setToysList(List<Toy> toysList) {
        this.toysList = toysList;
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
