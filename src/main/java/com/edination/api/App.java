package com.edination.api;

import com.edination.api.Dao.DemographicRepository;
import com.edination.api.Dao.MemberInsuranceRepository;
import com.edination.api.eligibility.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class App // implements CommandLineRunner
{

    public static void main(String[] args)
    {
        SpringApplication.run(App.class,args);
    }
    @Autowired
    private DemographicRepository demographicRepository;

/*@Autowired
MemberInsuranceRepository memberInsuranceRepository;
   @Override
    public void run(String...args) throws Exception {
       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
       Date startDate = formatter.parse("2020-02-22");
       Date endDate = formatter.parse("2021-02-21");
       Date startDatep = formatter.parse("2020-02-22");
       Date endDatep = formatter.parse("2021-02-21");
       Date startDates = formatter.parse("2020-02-19");
       Date endDates = formatter.parse("2021-02-18");
       Date startDatet = formatter.parse("2020-02-17");
       Date endDatet = formatter.parse("2021-02-16");
       Date statusverifiedate = formatter.parse("2020-04-22");
       Date dobdate=formatter.parse("1983-11-10");

       PrimaryInsuranceDetail Priinsurancedetail=new PrimaryInsuranceDetail("23415","34341","Plan one","Primary","#10 - Park street",startDatep,endDatep,"P105","KANSAS CITY","MO",64108,"Dan", "John","J",dobdate,"Male",statusverifiedate,"eligible",false);
       SecondaryInsuranceDetail secondaryInsuranceDetail=new SecondaryInsuranceDetail("23425","34341","Plan one","Secondary","#10 - Park street",startDates,endDates,"P105","KANSAS CITY","MO",64108,"Dan", "John","J",dobdate,"Male",statusverifiedate,"eligible",false);
       TertiaryInsuranceDetail tertiaryInsuranceDetail=new TertiaryInsuranceDetail("23426","34341","Plan one",  "Tertiary","#10 - Park street",startDatet,endDatet,"P105","KANSAS CITY","MO",64108,"Dan", "John","J",dobdate,"Male",statusverifiedate,"eligible",false);

       // InsuranceAndDiagnosis instructorDetail = new InsuranceAndDiagnosis("234-89-0976","Dan", "John","J","Male",new Date(1983-11-10 ),"card","Self","15197 BROADWAY AVENUE","KANSAS CITY","MO",64108);

        Demographics instructor = new Demographics("P105","Dan", "John", "J", "Mr", "Male",dobdate);
      InsuranceDetailByPolicy insuranceDetailByPolicy=new InsuranceDetailByPolicy("R1");
       insuranceDetailByPolicy.setPrimaryInsuranceDetail(Priinsurancedetail);
       insuranceDetailByPolicy.setSecondaryInsuranceDetail(secondaryInsuranceDetail);
       insuranceDetailByPolicy.setTertiaryInsuranceDetail(tertiaryInsuranceDetail);
       instructor.setInsuranceDetailByPolicy(insuranceDetailByPolicy);

        demographicRepository.save(instructor);
        *//*

       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
       Date startDate = formatter.parse("2020-02-22");
       Date endDate = formatter.parse("2021-02-21");
       Date startDatep = formatter.parse("2020-02-22");
       Date endDatep = formatter.parse("2021-02-21");
       Date startDates = formatter.parse("2020-02-19");
       Date endDates = formatter.parse("2021-02-18");
       Date startDatet = formatter.parse("2020-02-17");
       Date endDatet = formatter.parse("2021-02-16");
       Date statusverifiedate = formatter.parse("2020-04-22");
       Date dobdate=formatter.parse("2021-04-13");
       MemberInsuranceEligibility memberinsurance2=new MemberInsuranceEligibility();
       MemberInsuranceEligibility memberinsurance=new MemberInsuranceEligibility(startDate,endDate,statusverifiedate,"eligible","P105");

       //PrimaryInsuranceDetail Priinsurancedetail=new PrimaryInsuranceDetail("23415","34341","Plan one","Primary","#10 - Park street",startDatep,endDatep,"P105","KANSAS CITY","MO",64108);
       //SecondaryInsuranceDetail secondaryInsuranceDetail=new SecondaryInsuranceDetail("23425","34341","Medicare","Secondary","#10 - Park street",startDates,startDates,"P105","KANSAS CITY","MO",64108);
       //TertiaryInsuranceDetail tertiaryInsuranceDetail=new TertiaryInsuranceDetail("23426","34341","Medicare","Tertiary","#10 - Park street",startDatet,startDatet,"P105","KANSAS CITY","MO",64108);


       //memberinsurance.setPrimaryInsuranceDetail(Priinsurancedetail);
       //memberinsurance.setSecondaryInsuranceDetail(secondaryInsuranceDetail);
       //memberinsurance.setTertiaryInsuranceDetail(tertiaryInsuranceDetail);
       memberInsuranceRepository.save(memberinsurance);*//*
    }*/
}
