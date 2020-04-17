package com.edination.api.eligibility.rest;

import com.edination.api.Dao.DemographicsService;
import com.edination.api.controllers.X12Controller;
import com.edination.api.eligibility.EDIFile.EDIFileGeneration;
import com.edination.api.eligibility.EDIFile.SFTPFILE;
import com.edination.api.eligibility.model.Demographics;
import com.edination.api.models.GS;
import com.edination.api.models.X12Group;
import com.edination.api.models.X12Interchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.ws.rs.core.Response;
import java.io.*;
import java.util.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("checkEligibility")
public class RestApp {
    @Autowired
    DemographicsService service;
    X12Controller x12=new X12Controller();


    List<X12Interchange> list =new ArrayList<X12Interchange>();

    @GetMapping("/read")
    public List<Demographics> checkEligibility()  throws Throwable{
    /*    list= x12.read(f, false, false, " ", " ");
        String ackn="";
        for(X12Interchange l:list)
        {

            for(X12Group xx:l.getGroups()) {
                System.out.println(xx.getGETrailers()+" "+xx.getGS()+" "+xx.getTransactions());
            }
      ackn=l.getISA().getAcknowledgementRequested14();
        }*/

        return service.listAll();
    }




    @PostMapping("/write")
    public ResponseEntity<?> createDemographics(@RequestBody Demographics demographics) throws Throwable {
        Demographics demographics1=new Demographics();
       // saveOperation(demographics);
        Boolean preserveWhitespace = false;
        String charSet = "utf-8";
        String postfix = "  ";
        Boolean sameRepetionAndDataElement = false;
        Boolean eancomS3 = false;
        String contentType = "application/json";
        StringBuilder out = new StringBuilder();
        demographics1= service.get(demographics.getMrnNumber());
        File file = new File("Hipaa-5010-270-GenericRequest.txt");
        generateFile(demographics1,file);
        new SFTPFILE().uploadFile(file, demographics.getMrnNumber()+"_"+file.getName());
        File f1=new File("Hipaa-5010-271-GenericResponse.txt");
        new SFTPFILE().downloadFile(f1,demographics.getMrnNumber()+"_"+f1.getName());


        FileOutputStream outputStream = new FileOutputStream("271File-containt.txt");
        DataOutputStream dataOutStream = new DataOutputStream(new BufferedOutputStream(outputStream));
        List<X12Interchange>   list1= x12.read(f1, false, false, " ", " ");
        String ackn="";
        for(X12Interchange l:list1) {
            InputStream in = x12.write(preserveWhitespace, charSet, postfix, contentType, l);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line);
            }

            ackn=l.getISA().getAcknowledgementRequested14();
            byte[] strToBytes = out.toString().getBytes();
            outputStream.write(strToBytes);
            System.out.println(out.toString());   //Prints the string content read from input stream
            reader.close();
            outputStream.close();


        }
        if(ackn.equals("1")) {
            return generateSuccessObject(demographics1, "True",
                    " ");
        }
        else
        {
            return generateSuccessObject(demographics1, "False",
                    "Not Eligible ");
        }


    }

    public void generateFile(Demographics demographics1,File file)
    {
       String data=new EDIFileGeneration().generateFile(demographics1);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(data);
            System.out.println("File generated successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
public void saveOperation( Demographics demographics)
{
    for(Demographics demographics2:service.listAll()){
        if(demographics.getMrnNumber()!=demographics2.getMrnNumber())
        {
            service.save(demographics);
        }
    }
}

    protected ResponseEntity<?> generateSuccessObject(Object responseVal, String key, String errorBuilder){
        Response.ResponseBuilder builder = null;


        ResponseEntity responseEntity;

        try{
            Map<String, Object> responseObj = new HashMap<String, Object>();
            responseObj.put("Ackn",key);
            responseObj.put("Beneficiery detail", responseVal);
            responseEntity= new ResponseEntity<>(responseObj,HttpStatus.ACCEPTED);
        }catch (Exception e) {
            Map<String, Object> responseObj1 = new HashMap<String, Object>();
            responseObj1.put("Error",HttpStatus.BAD_REQUEST);
            responseEntity= new ResponseEntity<>(responseObj1,HttpStatus.EXPECTATION_FAILED);
        }
       return  responseEntity;
    }
}