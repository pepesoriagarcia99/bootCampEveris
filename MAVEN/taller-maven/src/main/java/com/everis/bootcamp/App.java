package com.everis.bootcamp;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public class App 
{
    public static void main( String[] args )
    {
        DateTimeFormatter dateFormat = DateTimeFormat
                .forPattern("dd-MM-YYYY <--> hh:mm:ss");
    	
        LocalDateTime localDateTime = new LocalDateTime();

    	System.out.println("dateFormatr : " + dateFormat.print(localDateTime));
        
       
    }
}
