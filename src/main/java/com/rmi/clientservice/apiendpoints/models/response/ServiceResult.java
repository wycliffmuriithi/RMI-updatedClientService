package com.rmi.clientservice.apiendpoints.models.response;

public class ServiceResult {
    String result;
    Object description;

    public ServiceResult(String result, String description) {
        this.result = result;
        this.description = description;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }
}
