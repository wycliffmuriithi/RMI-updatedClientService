package com.rmi.clientservice.apiendpoints;

import com.rmi.clientservice.apiendpoints.models.request.ServiceRequest;
import com.rmi.clientservice.apiendpoints.models.response.LoginResult;
import com.rmi.clientservice.apiendpoints.models.response.ServiceResult;
import com.rmi.clientservice.clientegine.ToyComputeTaskRegistry;
import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/toystore")
public class MainController {
    private static final Logger LOGGER = Logger.getLogger(MainController.class);

    @RequestMapping(path="/login")
    public @ResponseBody
    LoginResult cashierLogin(){
        return new LoginResult("Success","User Logged in successfully");
    }

    @RequestMapping(path="/service")
    public @ResponseBody
    ServiceResult toystoreService(@RequestBody ServiceRequest serviceRequest){
        String result = new ToyComputeTaskRegistry().getComputeEngineandExecute(serviceRequest.getTaskname(),serviceRequest.getTaskjob());
        return new ServiceResult("Success",result);
    }
}
