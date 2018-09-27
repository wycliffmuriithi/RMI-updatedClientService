package com.rmi.clientservice.apiendpoints.models.response;

public class LoginResult {
    String result;
    String description;

    public LoginResult(String result, String description) {
        this.result = result;
        this.description = description;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
