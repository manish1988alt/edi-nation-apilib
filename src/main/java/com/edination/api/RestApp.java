package com.edination.api;

import com.edination.api.controllers.X12Controller;
import com.edination.api.models.X12Interchange;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
public class RestApp {
    X12Controller x12=new X12Controller();
    File f=new File("C:\\Users\\manish\\Hipaa-5010-270-GenericRequest.txt");
    @GetMapping("/patient")
    public void checkEligibility()  throws Throwable{
        List<X12Interchange> list= x12.read(f, false, false, " ", " ");
        for(X12Interchange l:list)
        {

        }
        System.out.println("Read success");
    }
}
