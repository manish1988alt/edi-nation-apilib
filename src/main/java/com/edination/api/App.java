package com.edination.api;

import com.edination.api.Dao.DemographicRepository;
import com.edination.api.eligibility.model.Demographics;
import com.edination.api.eligibility.model.InsuranceAndDiagnosis;
import com.edination.api.eligibility.model.InsuranceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class App {

    public static void main(String[] args)
    {
        SpringApplication.run(App.class,args);
    }
    @Autowired
    private DemographicRepository demographicRepository;

  /*  @Override
    public void run(String...args) throws Exception {
        Date now = new Date();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String dates=formatter.format(now);
        InsuranceDetail insurancedetail=new InsuranceDetail("23411","34341","Plan one","Medicare","#10 - Park street","New York","New York",56010-1234);
        InsuranceAndDiagnosis instructorDetail = new InsuranceAndDiagnosis("123-99-1234","JOHN", "SMITH","","Male",new Date(2020-04-13),"card","Self","15197 BROADWAY AVENUE"
                ,"KANSAS CITY","MO",64108,insurancedetail);
        Demographics instructor = new Demographics("JOHN", "SMITH", "", "", "MALE",new Date(2020-04-13));
        instructor.setInsuranceAndDiagnosis(instructorDetail);
        demographicRepository.save(instructor);
    }*/
}
