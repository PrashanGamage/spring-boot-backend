package com.example.demo.services;

import com.example.demo.model.RestModel;
import com.example.demo.repository.UserRepo;
//import org.graalvm.compiler.phases.Phase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;


@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private UserRepo userRepo;
    public RestModel addMethod(RestModel restmodel)
    {

        Boolean isNewCard = false;
        int len = restmodel.getNic().length();
        int year = 0;
        int dateInput = 0;
        String gender = "Male";
        int dayArray[] = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int month = 0;
        String BIRTHDAY;
        long age = 0;
        boolean isLeapYear;

        if (len == 12) {
            isNewCard = true;
        }

        if (isNewCard) {
            year = Integer.parseInt(restmodel.getNic().substring(0, 4));
            dateInput = Integer.parseInt(restmodel.getNic().substring(4, 7));
        } else {
            year = Integer.parseInt(restmodel.getNic().substring(0, 2));
            dateInput = Integer.parseInt(restmodel.getNic().substring(2, 5));
        }

        if (dateInput > 500) {
            dateInput = dateInput - 500;
            gender = "Female";
        }

        for (int i = 0; i < dayArray.length; i++) {
            if (dateInput > dayArray[i]) {
                dateInput = dateInput - dayArray[i];
            } else {
                month = i + 1;
                break;
            }
        }
        String birthDay="";

        if (isNewCard) {
            birthDay=year + "-" + String.format("%02d",month) + "-" + String.format("%02d",dateInput);
            System.out.println(" Date of BIRTHDAY " + year + "-" + month + "-" + dateInput+" gender: "+gender);
        } else {
            birthDay=(1900+year) + "-" + String.format("%02d", month) + "-" + String.format("%02d",dateInput);
            System.out.println(" Date of BIRTHDAY "+(1900 + year) + "-" + month + "-" +dateInput+" gender: "+gender);
        }
        // divisible by 4
        isLeapYear = (year % 4 == 0);

        // divisible by 4, not by 100, or divisible by 400
        isLeapYear = isLeapYear && (year % 100 != 0 || year % 400 == 0);

        if(month==02&&dateInput==29&&isLeapYear==false){
           // return 0;

            // 	throw new Exception("Invalid NIC");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(Locale.ENGLISH);  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        LocalDate date = LocalDate.parse(birthDay, formatter);

        //Get Birthday to Age
        LocalDate startDate = LocalDate.parse(birthDay);
        LocalDate endDate = LocalDate.now();
        //alternative of LocalDate.now() method
        //calculates the amount of time between two specified temporal objects
        age = ChronoUnit.YEARS.between(startDate,endDate);
       // System.out.println("age"+age);
     //   System.out.println("birthday"+birthDay);
      //  System.out.println("gender"+gender);
        restmodel.setAge((int)age);
        restmodel.setBirthday(birthDay);
        restmodel.setGender(gender);
        return userRepo.save(restmodel);


    }
    public RestModel findid(Integer id)
    {
        return userRepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }

    public List<RestModel> getAllData(){
        return userRepo.findAll();
    }

    public RestModel update(Integer id, RestModel restModel){
        RestModel restModel11 = userRepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
        restModel11.setName(restModel.getName());
        restModel11.setAddress(restModel.getAddress());
        restModel11.setNationality(restModel.getNationality());
        restModel11.setNic(restModel.getNic());
        restModel11.setPno(restModel.getPno());
//        restModel11.setBirthday(restModel.getBirthday());
//        restModel11.setGender(restModel.getGender());
//        restModel11.setAge(restModel.getAge());
        return  userRepo.save(restModel11);
    }

    public void delete(Integer id){
        userRepo.deleteById(id);
    }
}
