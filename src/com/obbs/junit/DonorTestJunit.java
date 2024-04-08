package com.obbs.junit;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotEquals;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.obbs.exception.ApplicationException;
import com.obbs.model.DonorPojo;
import com.obbs.model.PostBloodRequirementPojo;
import com.obbs.service.DonorService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestBeanConfig.class })

public class DonorTestJunit {
	DonorPojo donorPojo = new DonorPojo();

	@Autowired
	DonorService donorService;

	@Test
	// correct username and password
	public void testDonorLogin1() throws ApplicationException {
		donorPojo.setEmail("kural@gmail.com");
		donorPojo.setPassword("kural");
		int login = donorService.donorLogin(donorPojo);
		assertNotEquals(0, login);

	}

	@Test
	// correct username and incorrect password
	public void testDonorLogin2() throws ApplicationException {
		donorPojo.setEmail("kural@gmail.com");
		donorPojo.setPassword("kurall");
		int login = donorService.donorLogin(donorPojo);
		assertEquals(0, login);

	}

	@Test
	// incorrect username and correct password
	public void testDonorLogin3() throws ApplicationException {
		donorPojo.setEmail("kurall@gmail.com");
		donorPojo.setPassword("kural");
		int login = donorService.donorLogin(donorPojo);
		assertEquals(0, login);

	}

	@Test
	// incorrect username and password
	public void testDonorLogin4() throws ApplicationException {
		donorPojo.setEmail("kurall@gmail.com");
		donorPojo.setPassword("kurall");
		int login = donorService.donorLogin(donorPojo);
		assertEquals(0, login);

	}

	@Test
	// Registering with existing mail
	public void testDonorMailCheck1() throws ApplicationException {
		donorPojo.setEmail("kural@gmail.com");
		int login = donorService.mailCheckDonor(donorPojo);
		assertEquals(1, login);

	}

	@Test
	// Registering with new mail
	public void testDonorMailCheck2() throws ApplicationException {
		donorPojo.setEmail("simran@gmail.com");
		int login = donorService.mailCheckDonor(donorPojo);
		assertNotEquals(1, login);

	}

	@Test
	// Slot booking date is before the blood required date
	public void testDateCheck1() throws ApplicationException, ParseException {
		String requiredDate = "06/20/2019";
		String bookingDate = "06/19/2019";

		int check = donorService.dateCheck(requiredDate, bookingDate);
		assertEquals(-1, check);
	}

	@Test
	// Slot booking date is same as the blood required date
	public void testDateCheck2() throws ApplicationException, ParseException {
		String requiredDate = "06/20/2019";
		String bookingDate = "06/20/2019";

		int check = donorService.dateCheck(requiredDate, bookingDate);
		assertEquals(0, check);
	}

	@Test
	// Slot booking date is after the blood required date
	public void testDateCheck3() throws ApplicationException, ParseException {
		String requiredDate = "06/20/2019";
		String bookingDate = "06/22/2019";

		int check = donorService.dateCheck(requiredDate, bookingDate);
		assertEquals(1, check);
	}

	@Test
	// Displaying the blood requirement details that matches the donor blood group
	public void testDisplayRequirements1() throws ApplicationException {

		String donorBloodGroup = "A -ve";
		List<PostBloodRequirementPojo> displayList = donorService.displayRequirements(donorBloodGroup);
		org.junit.Assert.assertTrue(!displayList.isEmpty());
	}

	@Test
	// If donor blood group does not matches with recipients blood group
	public void testDisplayRequirements2() throws ApplicationException {

		String donorBloodGroup = "B +ve";
		List<PostBloodRequirementPojo> displayList = donorService.displayRequirements(donorBloodGroup);
		org.junit.Assert.assertTrue(displayList.isEmpty());
	}

}
