package com.reservationservicetest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.reservationservice.entities.Reservation;
import com.reservationservice.repositories.ReservationRepository;
import com.reservationservice.services.ReservationService;
import com.reservationservice.services.ReservationServiceImplementation;

@SpringBootTest
public class ReservationServiceTest {

	public ReservationServiceImplementation impl;
	public ReservationRepository rep;
	public ReservationService rs;
	
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
		impl = new ReservationServiceImplementation();
	}
	
	@After
    public void tearDown() {
        System.out.println("tear down");
        System.out.flush();
    }
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetReservationRepository() {
		impl.setReservationRepository(null);
	}

	@Test
	public void testListAllReservations() {
		fail("Not yet implemented"); // TODO
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetReservationById() {
		impl.getReservationById(null);
		
	}

	@Test
	public void testSaveReservation() {
		Reservation res = new Reservation();
		//long size = rep.count();
		impl.setReservationRepository(rep);
		impl.saveReservation(res);
		
		//assertEquals(size+1,rep.count());
		assertTrue(rep.count() > 0);
	}

	@Test
	public void testDeleteReservation() {
		impl = new ReservationServiceImplementation();
		Reservation res = new Reservation();
		//long size = rep.count();
		//System.out.println(size);
		res.setId(1);
		impl.saveReservation(res);
		impl.deleteReservation(1);
		assertEquals(0,rep.count());
	}

}
