package com.techelevator.view;


import javax.swing.text.DateFormatter;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTime {

    LocalDateTime myDateObj= LocalDateTime.now();
    DateTimeFormatter myFormatObj= DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
    private String AmPm;
    String formattedDateNTime=myDateObj.format(myFormatObj);


    public void printAmPm(String formattedDateNTime){
        int hh=Integer.parseInt(formattedDateNTime.substring(12,14));

        if(hh>=12 && hh<=23){
            AmPm="PM";
            if( hh>= 00 && hh<12){
                AmPm="AM";
            }
        }
        System.out.println( formattedDateNTime + " "+ AmPm);

        }


    public String getAmPm() {
        return AmPm;
    }

    public void setAmPm(String amPm) {
        AmPm = amPm;
    }
}


