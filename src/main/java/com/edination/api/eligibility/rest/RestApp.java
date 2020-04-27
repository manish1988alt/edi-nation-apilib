package com.edination.api.eligibility.rest;

import com.edination.api.Dao.DemographicRepository;
import com.edination.api.Dao.DemographicsService;
import com.edination.api.Dao.MemberInsuranceRepository;
import com.edination.api.Dao.MemberInsuranceService;
import com.edination.api.controllers.X12Controller;
import com.edination.api.eligibility.EDIFile.EDIFileGeneration;
import com.edination.api.eligibility.EDIFile.SFTPFILE;
import com.edination.api.eligibility.model.Demographics;
import com.edination.api.eligibility.model.MemberInsuranceEligibility;
import com.edination.api.models.X12Interchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.*;

import static org.apache.logging.log4j.util.Strings.EMPTY;


/*@CrossOrigin(origins = "http://localhost:4200")*/
@RestController
@RequestMapping("checkEligibility")
public class RestApp implements Serializable {
    @Autowired
    DemographicsService service;
    @Autowired
    MemberInsuranceService memberInsuranceService;
    @Autowired
    MemberInsuranceRepository memberInsuranceRepository;
    @Autowired
    DemographicRepository demographicRepository;

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
        //new SFTPFILE().uploadFile(file, demographics.getMrnNumber()+"_"+file.getName());
        String ackn=new SFTPFILE().fileUpload(file, demographics.getMrnNumber()+"_"+file.getName());

        File f1=new File("Hipaa-5010-271-GenericResponse.txt");
        new SFTPFILE().downloadFile(f1,demographics.getMrnNumber()+"_"+f1.getName());


     /*   FileOutputStream outputStream = new FileOutputStream("271File-containt.txt");
        DataOutputStream dataOutStream = new DataOutputStream(new BufferedOutputStream(outputStream));*/
       /* List<X12Interchange>   list1= x12.read(f1, false, false, " ", " ");
        String ackn="";
        for(X12Interchange l:list1) {
            *//*InputStream in = x12.write(preserveWhitespace, charSet, postfix, contentType, l);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line);
            }*//*

        //    ackn=l.getISA().getAcknowledgementRequested14();

      *//*      byte[] strToBytes = out.toString().getBytes();
            outputStream.write(strToBytes);
            //System.out.println(out.toString());   //Prints the string content read from input stream
           // reader.close();
            outputStream.close();*//*


        }*/
        if(ackn.equals("true")) {
            return generateSuccessObject(demographics1,"true",
                    " ");
        }
        else
        {
            return generateSuccessObject(demographics1, "false",
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

    protected ResponseEntity<?> generateSuccessObject(Demographics demographics1, String key, String errorBuilder){
        Response.ResponseBuilder builder = null;

        ResponseEntity responseEntity;

        try{
            Map<String, Object> responseObj = new HashMap<String, Object>();
            responseObj.put("ackn",key);
            responseEntity= new ResponseEntity<>(responseObj,HttpStatus.ACCEPTED);
        }catch (Exception e) {
            Map<String, Object> responseObj1 = new HashMap<String, Object>();
            responseObj1.put("Error",HttpStatus.BAD_REQUEST);
            responseEntity= new ResponseEntity<>(responseObj1,HttpStatus.EXPECTATION_FAILED);
        }
       return  responseEntity;
    }
    @PostMapping("/eligibilityDetail")
    public List<MemberInsuranceEligibility> eligibilityDetail(@RequestBody MemberInsuranceEligibility memberInsuranceEligibility) throws Throwable
    {
     /*SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = formatter.parse("2020-04-22");
        Date endDate = formatter.parse("2021-04-21");
        Date statusverifiedate = formatter.parse("2020-04-22");
        Date dobdate=formatter.parse("2021-04-13");
        MemberInsuranceEligibility memberinsurance2=new MemberInsuranceEligibility();
        MemberInsuranceEligibility memberinsurance=new MemberInsuranceEligibility("23418",startDate,endDate,statusverifiedate,"eligible",memberInsuranceEligibility.getMrnNumber());
        InsuranceDetail insurancedetail=new InsuranceDetail("23418","34341","Medicare","Tertiary","#10 - Park street","New York","New York",56010-1234);
        memberinsurance.setInsuranceDetail(insurancedetail);
        memberInsuranceRepository.save(memberinsurance);*/

        List<Object> list1=new ArrayList<>();
        List<MemberInsuranceEligibility> list =memberInsuranceRepository.findByMrnNumber(memberInsuranceEligibility.getMrnNumber());
     /* List<Demographics> demographicsval=demographicRepository.findByMrnNumber(memberInsuranceEligibility.getMrnNumber());
        list1.addAll(demographicsval);
        list1.addAll(list);
*/
          return list;


    }
   private static final String HEADER1 = "Content-Disposition";
    private static final String HEADER_VAL_ATTACHMENT = "attachment; filename=";
    private static final String HEADER2 = "Content-Type";
    private static final String HEADER4 = "Content-length";
    private static final String HEADER3 = "Set-Cookie";
    private static final String HEADER3_FIXED_VAL = "fileDownload=true; path=/";
    private static final String SEMICOLON = ";";
    private static final String HEADER_VAL_INLINE = "inline";
    private static final String PDF = "application/pdf";
    private static final String XML = "application/xml";
    private static final String TEXT = "text/";
    private static final String IMAGE = "image/";
    protected static final String QUOTE = "\"";



    @PostMapping("/generate")
    public ResponseEntity<InputStreamResource> getPdf2(MemberInsuranceEligibility memberInsuranceEligibility)
    {     String contentDisposition = HEADER_VAL_ATTACHMENT; // By default
        StringBuilder attachement = new StringBuilder(EMPTY);
        String fileName = EMPTY;
        contentDisposition = attachement.append("inline; filename=").append(QUOTE).append(fileName).append(QUOTE).append(SEMICOLON).toString();

        Resource resource=new ClassPathResource("/PatientDischargeCode.pdf");
        fileName = resource.getFilename();
        long r=0;
        InputStream is=null;
        try{
            is=resource.getInputStream();
            r=resource.contentLength();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        // return ResponseEntity.ok().contentLength(r).contentType(MediaType.parseMediaType("application/pdf")).body(new InputStreamResource(is));
        return   ResponseEntity.ok().header(contentDisposition,HEADER3_FIXED_VAL).contentLength(r).contentType(MediaType.parseMediaType("application/pdf")).body(new InputStreamResource(is));
    }
}