package com.obbs.junit;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.obbs.exception.ApplicationException;
import com.obbs.model.DonorPojo;
import com.obbs.model.RecipientPojo;
import com.obbs.service.RecipientService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestBeanConfig.class })
public class RecipientTestJunit {
	RecipientPojo recipientPojo = new RecipientPojo();

	@Autowired
	RecipientService recipientService;

	@Test
	// Matching blood group and area
	public void testSearchDonor1() throws ApplicationException {
		recipientPojo.setBloodGroup("O -ve");
		recipientPojo.setArea("Chennai");
		List<DonorPojo> donors = recipientService.donorCheck(recipientPojo);
		org.junit.Assert.assertTrue(!donors.isEmpty());

	}

	@Test
	// Matching blood group and area
	public void testSearchDonor2() throws ApplicationException {
		recipientPojo.setBloodGroup("O -ve");
		recipientPojo.setArea("Madras");
		List<DonorPojo> donors = recipientService.donorCheck(recipientPojo);
		org.junit.Assert.assertTrue(donors.isEmpty());

	}
}
