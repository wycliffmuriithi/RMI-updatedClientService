package com.rmi.clientservice.apiendpoints.models.request;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

public class ServiceRequest implements Serializable {
    String taskname;
    String taskjob;

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getTaskjob() {
        return taskjob;
    }

    public void setTaskjob(Object taskjob) {
        try {
            this.taskjob = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(taskjob);
        }catch (Exception e){
            this.taskjob = taskjob.toString();
        }
        return;
    }
}
