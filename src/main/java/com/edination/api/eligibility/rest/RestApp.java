package com.edination.api.eligibility.rest;

import com.edination.api.Dao.*;
import com.edination.api.controllers.X12Controller;
import com.edination.api.eligibility.EDIFile.EDIFileGeneration;
import com.edination.api.eligibility.EDIFile.SFTPFILE;
import com.edination.api.eligibility.model.*;
import com.edination.api.models.*;
/*import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;;
import com.sun.javafx.font.FontFactory;
import javafx.scene.text.Font;*/
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
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
import java.util.List;

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
    @Autowired
    EDI271Repository edi271Repository;
    @Autowired
    EDI271Service edi271Service;

    X12Controller x12=new X12Controller();
    EdiDataElement271 ediDataElement271=new EdiDataElement271();
    EdiDataElement271 ediDataElement272=new EdiDataElement271();
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
        List<X12Interchange>   list1= x12.read(f1, false, false, " ", " ");
        System.out.println("Insertion method called");
        String eligibility="";
        ediDataElement272=  new exampleParseX12FileOne().insertOpertion271(f1,ediDataElement271,demographics1.getMrnNumber());
        edi271Service.save(ediDataElement272);
        List<EdiDataElement271> list2 =edi271Repository.findByMrnNumber(demographics.getMrnNumber());

        for(EdiDataElement271 edi271:list2) {
            eligibility=edi271.getEligibilityorBenefitInformation();
        }

        /*List<MemberInsuranceEligibility> list =memberInsuranceRepository.findByMrnNumber(demographics.getMrnNumber());
        MemberInsuranceEligibility memberinsurance2=new MemberInsuranceEligibility();
        PrimaryInsuranceDetail insurancedetail=null;
        SecondaryInsuranceDetail secondaryInsuranceDetail=null;
        TertiaryInsuranceDetail  tertiaryInsuranceDetail=null;
        for(MemberInsuranceEligibility mm:list) {
            memberinsurance2= new MemberInsuranceEligibility(mm.getStartDate(), mm.getEndDate(),mm.getStatusVerifiedDate(), eligibility, mm.getMrnNumber());
            //insurancedetail=new PrimaryInsuranceDetail(mm.getPrimaryInsuranceDetail().getPolicyNumber(),mm.getPrimaryInsuranceDetail().getGroup_name(),mm.getPrimaryInsuranceDetail().getInsurancePlanName(),mm.getPrimaryInsuranceDetail().getInsurancePlanType(),mm.getPrimaryInsuranceDetail().getInsuranceAddress(),mm.getPrimaryInsuranceDetail().getStartDate(),mm.getPrimaryInsuranceDetail().getEndDate(),mm.getMrnNumber(),mm.getPrimaryInsuranceDetail().getCity(),mm.getPrimaryInsuranceDetail().getState(),mm.getPrimaryInsuranceDetail().getZipcode());
            ////secondaryInsuranceDetail=new SecondaryInsuranceDetail(mm.getSecondaryInsuranceDetail().getPolicyNumber(),mm.getSecondaryInsuranceDetail().getGroup_name(),mm.getSecondaryInsuranceDetail().getInsurancePlanName(),mm.getSecondaryInsuranceDetail().getInsurancePlanType(),mm.getSecondaryInsuranceDetail().getInsuranceAddress(),mm.getSecondaryInsuranceDetail().getStartDate(),mm.getSecondaryInsuranceDetail().getEndDate(),mm.getMrnNumber(),mm.getSecondaryInsuranceDetail().getCity(),mm.getSecondaryInsuranceDetail().getState(),mm.getSecondaryInsuranceDetail().getZipcode());
            //tertiaryInsuranceDetail=new TertiaryInsuranceDetail(mm.getTertiaryInsuranceDetail().getPolicyNumber(),mm.getTertiaryInsuranceDetail().getGroup_name(),mm.getTertiaryInsuranceDetail().getInsurancePlanName(),mm.getTertiaryInsuranceDetail().getInsurancePlanType(),mm.getTertiaryInsuranceDetail().getInsuranceAddress(),mm.getTertiaryInsuranceDetail().getStartDate(),mm.getTertiaryInsuranceDetail().getEndDate(),mm.getMrnNumber(),mm.getTertiaryInsuranceDetail().getCity(),mm.getTertiaryInsuranceDetail().getState(),mm.getTertiaryInsuranceDetail().getZipcode());
        }
            // memberinsurance2.setPrimaryInsuranceDetail(insurancedetail);
            // memberinsurance2.setSecondaryInsuranceDetail(secondaryInsuranceDetail);
            // memberinsurance2.setTertiaryInsuranceDetail(tertiaryInsuranceDetail);
              memberInsuranceRepository.save(memberinsurance2);*/

        for(X12Interchange l:list1) {

            for(X12Group s: l.getGroups())
            {
                List<Object> ss=s.getTransactions();

            }

        }


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

          ackn=l.getISA().getAcknowledgementRequested14();

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
    @PostMapping("/eligibilityDetailHistory")
    public List<MemberInsuranceEligibility> eligibilityDetailHistory(@RequestBody MemberInsuranceEligibility memberInsuranceEligibility) throws Throwable
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

          return list;


    }
    @PostMapping("/eligibilityDetail")
    public List<MemberInsuranceEligibility> eligibilityDetail(@RequestBody MemberInsuranceEligibility memberInsuranceEligibility) throws Throwable
    {

        List<MemberInsuranceEligibility> list =memberInsuranceRepository.findByID(memberInsuranceEligibility.getMrnNumber());
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
    public ResponseEntity<InputStreamResource> getPdf2(@RequestBody MemberInsuranceEligibility memberInsuranceEligibility) throws Throwable
    {
         //this.pdfGenerator(memberInsuranceEligibility.getMrnNumber());
        String contentDisposition = HEADER_VAL_ATTACHMENT; // By default
        StringBuilder attachement = new StringBuilder(EMPTY);
        String fileName = EMPTY;
        String charSet = "utf-8";
        contentDisposition = attachement.append("inline; filename=").append(QUOTE).append(fileName).append(QUOTE).append(SEMICOLON).toString();

   /*     System.out.println("PolicyType: "+memberInsuranceEligibility.getInsuranceDetail().getInsurancePlanType());
        System.out.println(" MRN: "+memberInsuranceEligibility.getMrnNumber());
        System.out.println(" Policy Number:"+memberInsuranceEligibility.getPolicyNumber());*/
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
    public void pdfGenerator(String mrnNumber)
    {
        Font blueFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
        Font redFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(0, 255, 0, 0));
        Font yellowFont = FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 255, 0));
        Document document = new Document();
        List<EdiDataElement271> list2 =edi271Repository.findByMrnNumber(mrnNumber);
        try
        {
         File f=new File("PatientDischargeCode.pdf");
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(f));
            document.open();
            //document.add(new Paragraph("Styling Example"));

            //Paragraph with color and font styles
            Paragraph paragraphOne = new Paragraph("Eligibility Detail", redFont);
            document.add(paragraphOne);

            //Create chapter and sections
            Paragraph chapterTitle = new Paragraph("Eligibility Detail PDF", yellowFont);
            Chapter chapter1 = new Chapter(chapterTitle, 1);
            chapter1.setNumberDepth(0);

            Paragraph sectionTitle = new Paragraph("Demograhic detail", redFont);
            Section section1 = chapter1.addSection(sectionTitle);
            for(EdiDataElement271 edi271:list2) {
                Paragraph sectionContent1 = new Paragraph(edi271.getSubscriberPrimaryIdentifier(), blueFont);
                section1.add(sectionContent1);
                Paragraph sectionContent2 = new Paragraph(edi271.getSubscriberSupplementalIdentifier(), blueFont);
                section1.add(sectionContent2);
                Paragraph sectionConten3 = new Paragraph(edi271.getSubscriberLastName(), blueFont);
                section1.add(sectionConten3);
                Paragraph sectionContent4 = new Paragraph(edi271.getSubscriberFirstName(), blueFont);
                section1.add(sectionContent4);
                Paragraph sectionContent5 = new Paragraph(edi271.getSubscriberNameSuffix(), blueFont);
                section1.add(sectionContent5);
                Paragraph sectionContent6 = new Paragraph(edi271.getSubscriberAddressLine(), blueFont);
                section1.add(sectionContent6);
                Paragraph sectionContent7 = new Paragraph(edi271.getSubscriberCityName(), blueFont);
                section1.add(sectionContent7);
                Paragraph sectionContent8 = new Paragraph(edi271.getSubscriberStateCode(), blueFont);
                section1.add(sectionContent8);
                Paragraph sectionContent9 = new Paragraph(edi271.getSubscriberStateCode(), blueFont);
                section1.add(sectionContent9);
                Paragraph sectionContent10 = new Paragraph(edi271.getSubscriberZipCode(), blueFont);
                section1.add(sectionContent10);
            }


            document.add(chapter1);

            document.close();
            writer.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}