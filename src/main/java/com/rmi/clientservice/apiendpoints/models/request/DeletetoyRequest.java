package com.rmi.clientservice.apiendpoints.models.request;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DeletetoyRequest {
    String username;
    String password;
    String toyname;

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
