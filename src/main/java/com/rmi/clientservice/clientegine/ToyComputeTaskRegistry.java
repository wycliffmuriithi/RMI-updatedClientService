package com.rmi.clientservice.clientegine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rmi.clientservice.apiendpoints.models.request.*;
import com.toys.wholesaletoyservice.compute.Compute;
import com.toys.wholesaletoyservice.rmi.clienttasks.*;
import org.jboss.logging.Logger;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * ToyComputeTaskRegistry
 *  this class
 *      1. looks for the ToyComputeEngine located in the registry
 *      2. creates a client task
 *      3. Executes the client task on the ToyComputeEngine
 */
public class ToyComputeTaskRegistry {
    private static final String SERVER_REGISTRY_URL = "Compute";
    private static final Logger LOGGER = Logger.getLogger(ToyComputeTaskRegistry.class);
    private final ObjectMapper objectMapper  = new ObjectMapper();
    public String getComputeEngineandExecute(String taskname, String taskjob){
        /**
         * set up client to communicate with server service over RMI
         */
        try {

            Registry registry= LocateRegistry.getRegistry(1099);
            Compute comp=(Compute) registry.lookup(SERVER_REGISTRY_URL);

            String taskresult = "";
            switch (taskname) {
                case "addtoy":
                    AddtoyRequest addtoyRequest = objectMapper.readValue(taskjob,AddtoyRequest.class);
                    AddToyPrice newtoyentity = new AddToyPrice(addtoyRequest.toString());
                    taskresult = comp.executeTask(newtoyentity);
                    break;
                case "getCost":
                    CalculatetoycostRequest calculatetoycostRequest = objectMapper.readValue(taskjob,CalculatetoycostRequest.class);
                    CalculateToyCost totaltoycost = new CalculateToyCost(calculatetoycostRequest.toString());
                    taskresult = comp.executeTask(totaltoycost);
                    break;
                case "printreceipt":
                    PrintreceiptRequest printreceiptRequest = objectMapper.readValue(taskjob,PrintreceiptRequest.class);
                    CalculateCost purchasereceipt = new CalculateCost(printreceiptRequest.toString());
                    taskresult = comp.executeTask(purchasereceipt);
                    break;
                case "deletetoy":
                    DeletetoyRequest deletetoyRequest = objectMapper.readValue(taskjob,DeletetoyRequest.class);
                    DeleteToyPrice removetoyentity = new DeleteToyPrice(deletetoyRequest.toString());
                    taskresult = comp.executeTask(removetoyentity);
                    break;
                case "updateprice":
                    AddtoyRequest updatepriceRequest = objectMapper.readValue(taskjob,AddtoyRequest.class);
                    UpdateToyPrice updatetoyentity = new UpdateToyPrice(updatepriceRequest.toString());
                    taskresult = comp.executeTask(updatetoyentity);
                    break;
                default:
                    taskresult = "invalid selection";
                    break;
            }
            LOGGER.info("Result from the server " + taskresult);
            return taskresult;
        } catch (Exception e) {
            LOGGER.error("Error sending client task");
            e.printStackTrace();
        }
        return "Task execution Failed";
    }
}
