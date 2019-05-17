package com.Projekt.Jakosc_Oprogramowania;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	@RequestMapping("/")
	public String Start() {
		return "Start";
	}
	@RequestMapping("/add")
	public String Add() {
		return "AddReservation";
	}

	@RequestMapping(value="/reservations", method = RequestMethod.GET)
	public ModelAndView getdata() throws ParseException {

		

		List<Reservation> list = getReservations();
		//return back to index.jsp
		ModelAndView model = new ModelAndView("reservations");
		model.addObject("lists", list);

		return model;

	}
	
	
	public List<Reservation> getReservations() throws ParseException {
			return ReservationService.getReservations();
		}


	}

	/*@RequestMapping(value="/addTest", method = RequestMethod.POST)
	public Reservation newReservation(Reservation testRes){


	}*/




