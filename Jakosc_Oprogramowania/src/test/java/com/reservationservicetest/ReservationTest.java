package com.reservationservicetest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.reservationservice.entities.Reservation;

public class ReservationTest {

	private Reservation reservation;

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
		reservation = new Reservation();
	}

	@After
	public void tearDown() {
		System.out.println("tear down");
		System.out.flush();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetResObject() {
		System.out.println("test resObject");
		reservation.setResObject("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetFirstName() {
		System.out.println("test firstName");
		reservation.setFirstName("");
	}

	@Test
	public void testGetFirstName() {
		reservation.setFirstName("Michał");
		assertEquals("Michał", reservation.getFirstName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetLastName() {
		System.out.println("test lastName");
		reservation.setLastName("");
	}

	@Test
	public void testGetLastName() {
		reservation.setLastName("Kowalski");
		assertNotEquals("Nowak", reservation.getLastName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetResDate() {
		System.out.println("test setDate");
		reservation.setResDate("20199-06-30T10:10");
	}

}
