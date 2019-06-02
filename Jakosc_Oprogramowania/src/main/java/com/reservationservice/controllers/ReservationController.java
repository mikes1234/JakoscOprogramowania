package com.reservationservice.controllers;

import com.reservationservice.entities.Reservation;
import com.reservationservice.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public void setProductService(ReservationService reservationService) {
    	if(reservationService == null) {
        	throw new IllegalArgumentException("Negative value");
        }
    	this.reservationService = reservationService;
    }

    @RequestMapping(value = "/reservations", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("reservations", reservationService.listAllReservations());
        //System.out.println("Returning reservations:");
        return "reservations"; 
        
    }

    @RequestMapping("reservation/{id}")
    public String showReservation(@PathVariable Integer id, Model model) {
        model.addAttribute("reservation", reservationService.getReservationById(id));
        return "reservationshow";
    }

    @RequestMapping("reservation/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("reservation", reservationService.getReservationById(id));
        return "reservationform";
    }

    @RequestMapping("reservation/new")
    public String newReservation(Model model) {
        model.addAttribute("reservation", new Reservation());
        
        System.out.println(reservationService.getReservationById(1).getResObject());
        return "reservationform";
        
        
    }

    @RequestMapping(value = "reservation", method = RequestMethod.POST)
    public String saveReservation(Reservation reservation) {
        reservationService.saveReservation(reservation);
        return "redirect:/reservation/" + reservation.getId();
    }

    @RequestMapping("reservation/delete/{id}")
    public String delete(@PathVariable Integer id) {
        reservationService.deleteReservation(id);
        return "redirect:/reservations";
    }

}