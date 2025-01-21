package rahul;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class DateAndTime {
    public static void main(String[] args) {
        System.out.println(LocalDate.now());//returns current date
        System.out.println(LocalDate.of(2004,2,5));//provides day of given date
       // System.out.println(LocalDate.plusDays(20));                   //Gets a copy of the LocalDate after
       // System.out.println( LocalDate.plusMonths(long months));      //adding the number of
        //System.out.println( LocalDate.plusYears(long years));       //days/months/years that is passed
       // System.out.println( LocalDate.parse(20,"dd/mm/yyyy"));
        System.out.println();
        Date d=new Date("3");
        System.out.println(d.getDay());

    }
}
