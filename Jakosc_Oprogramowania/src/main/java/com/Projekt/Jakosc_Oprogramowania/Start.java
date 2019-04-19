package com.Projekt.Jakosc_Oprogramowania;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Start {

	@RequestMapping("/czesc")
	public String czesc() {
		return "Projekt na zaliczenie";
	}
}
