package com.reservationservicetest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.reservationservice.AppRunner;
import com.reservationservice.entities.Reservation;
import com.reservationservice.repositories.ReservationRepository;
import com.reservationservice.services.ReservationServiceImplementation;

import net.sourceforge.htmlunit.corejs.javascript.ast.ErrorCollector;

@SpringBootTest(classes = AppRunner.class)
@RunWith(SpringRunner.class)
@DataJpaTest
//@AutoConfigureTestDatabase
public class ReservationServiceTest {

	@InjectMocks
	private ReservationServiceImplementation reservationImplementation;
	
	@Autowired
	private ReservationRepository reservationRepository;

	@Mock
	private Reservation res;
	
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
		res = new Reservation();
	}

	@After
	public void tearDown() {
		System.out.println("tear down");
		System.out.flush();
	}

	@Ignore
	@Test
	public void ignoredTest() {

	}

	@Test
	public void testListAllReservations() {
		res.setId(1);
		res.setResObject("table");
		Reservation res2 = new Reservation();
		res.setId(2);
		res.setResObject("room");

		reservationRepository.save(res);
		reservationRepository.save(res2);

		System.out.println("TTTTTTTTTTTTT");
	}

	@Test
	public void testGetReservationById() {
		String lastName = "Michalski";
		res.setId(5);
		res.setLastName(lastName);

		reservationRepository.save(res);

		assertEquals(lastName, reservationRepository.findOne(5).getLastName());
		assertNotEquals("Kowalski", reservationRepository.findOne(5).getLastName());
	}

	@Test
	public void testSaveReservation() {
		res.setId(4);
		res.setResObject("table");
		res.setFirstName("Dorian");
		res.setLastName("Michalski");

		int empty = (int) reservationRepository.count();
		reservationRepository.save(res);
		
		assertEquals(empty + 1, reservationRepository.count());
		assertNotEquals(empty, reservationRepository.count());
		assertTrue(reservationRepository.count() > 0);
	}

	/*
	 * @Rule public ErrorCollector collector = new ErrorCollector();
	 */

	@Test
	public void testDeleteReservation() {
		res.setId(4);
		res.setResObject("table");
		res.setFirstName("Dorian");
		res.setLastName("Michalski");

		reservationRepository.save(res);
		reservationRepository.delete(4);

		assertEquals(0, reservationRepository.count());
		assertFalse(reservationRepository.count() > 0);

	}

}
