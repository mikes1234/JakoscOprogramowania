package com.Projekt.Jakosc_Oprogramowania;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

	@RequestMapping("/")
	public String welcome() {
		return "welcome";
	}

	@RequestMapping(value="/reservations", method = RequestMethod.GET)
	public List<Reservation> getReservations(Reservation testRes) throws ParseException {
			return ReservationService.getReservations();
		}


	}

	/*@RequestMapping(value="/addTest", method = RequestMethod.POST)
	public Reservation newReservation(Reservation testRes){


	}*/




