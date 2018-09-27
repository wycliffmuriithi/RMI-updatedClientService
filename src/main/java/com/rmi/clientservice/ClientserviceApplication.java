package com.rmi.clientservice;

import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientserviceApplication {
    private static final Logger LOGGER = Logger.getLogger(ClientserviceApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(ClientserviceApplication.class, args);

    }
}
