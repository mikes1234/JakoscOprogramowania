package com.reservationservicetest;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import javax.validation.constraints.AssertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.ui.Model;

import com.reservationservice.controllers.ReservationController;
import com.reservationservice.entities.Reservation;
import com.reservationservice.services.ReservationServiceImplementation;

public class ReservationControllerTest {

	Model model;
	ReservationController reservationController;
	ReservationServiceImplementation impl;
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("set up class");
        System.out.flush();
	}

	@AfterClass
	public static void tearDownClass() {
		System.out.println("tear down class");
        System.out.flush();
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("set up");
		reservationController = new ReservationController();
		impl = new ReservationServiceImplementation();
	}
	
	@After
    public void tearDown() {
        System.out.println("tear down");
        System.out.flush();
    }
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetProductService() {
		reservationController.setProductService(null);
	}

	@Test
	public void testList() {
		reservationController.list(model);
	}

	@Test
	public void testShowReservation() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testEdit() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testNewReservation() {
		//int beginning = model.asMap().size();
		//System.out.println(beginning);
		reservationController.newReservation(model);
		assertEquals(1,model.asMap().size());
		//assertTrue(model.containsAttribute("reservation"));		
		
	}

	@Test
	public void testSaveReservation() {
		
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented"); // TODO
	}

}
