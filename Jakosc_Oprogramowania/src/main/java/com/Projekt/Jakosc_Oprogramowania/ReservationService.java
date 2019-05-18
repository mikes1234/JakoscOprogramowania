package com.Projekt.Jakosc_Oprogramowania;

import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ReservationService {



    public static List<Reservation> getReservations() throws ParseException {

        List<Reservation> resList = new ArrayList<>();
        Reservation testRes = new Reservation();
        testRes.setId(1);
        testRes.setResObject("Stolik");
        testRes.setFirstName("Jakub");
        testRes.setLastName("Dziekoński");
        
        Reservation testRes2 = new Reservation();
        testRes2.setId(2);
        testRes2.setResObject("Pokój");
        testRes2.setFirstName("Mikołaj");
        testRes2.setLastName("Maik");
        

        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = "31-08-1982 10:20:56";
        Date date = sdf.parse(dateInString);

        testRes.setResDate(date);
        testRes2.setResDate(date);
        resList.add(testRes);
        resList.add(testRes2);

        for(Reservation reservation : resList){
            System.out.println(reservation.getId());
            System.out.println(reservation.getResObject());
            System.out.println(reservation.getFirstName());
            System.out.println(reservation.getLastName());
            System.out.println(reservation.getResDate());
        }
        
        
        return resList;
    }

}
