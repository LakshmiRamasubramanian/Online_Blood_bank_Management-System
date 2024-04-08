package com.obbs.controller;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.obbs.exception.ApplicationException;
import com.obbs.model.BloodGroupPojo;
import com.obbs.model.DonorPojo;
import com.obbs.model.HospitalPojo;
import com.obbs.model.PostBloodRequirementPojo;
import com.obbs.model.RecipientPojo;
import com.obbs.model.StatesPojo;

import com.obbs.service.RecipientService;
import com.obbs.service.UsersService;

@Controller // This Annotation specifies the Controllers
public class RecipientController {

	@Autowired // This is used to creating Object
	RecipientService recipientService;
	@Autowired // This is used to creating Object
	UsersService usersService;
	public static final Logger LOGGER = Logger.getLogger("OBBS");

	@RequestMapping(value = "/postBloodRequirement", method = RequestMethod.GET)
	// this is used to display the Blood Required by the recipient in Home Page.
	public ModelAndView postBloodRequirement(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;
		HttpSession session = request.getSession(false);

		try {
			if (session.getAttribute("username") != null) {
				List<StatesPojo> allStates = usersService.getAllStates();
				List<BloodGroupPojo> allBloodGroups = usersService.getAllBloodGroups();
				List<HospitalPojo> allHospitals = recipientService.getAllHospitals();
				mav = new ModelAndView("PostBloodRequirement");
				map.addAttribute("requisterPojo", new PostBloodRequirementPojo());
				mav.addObject("allHospitals", allHospitals);
				mav.addObject("allStates", allStates);
				mav.addObject("allBloodGroups", allBloodGroups);
			} else {
				mav = new ModelAndView("Home");
			}
		} catch (ApplicationException e) {
			LOGGER.error(e.getMessage());
			mav = new ModelAndView("Error");
			mav.addObject("message", e.getMessage());
		}
		return mav;
	}

	@RequestMapping("/insertBloodRequirement")
	// This method id used to Post Requirement of the recipient incase of donor is
	// not Available
	public ModelAndView insertBloodRequirement(
			@Valid @ModelAttribute("requisterPojo") PostBloodRequirementPojo requisterPojo, BindingResult result,
			HttpServletRequest request, HttpServletResponse response) throws ApplicationException {
		int id;
		int temp;
		int check = 1;
		ModelAndView mav = null;
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		if (!result.hasErrors()) {
			try {
				if (session.getAttribute("username") != null) {
					requisterPojo.setUserMailID(username);
					id = recipientService.insertBloodRequirement(requisterPojo);

					if (id == check) {
						temp = recipientService.insertBloodRequirementDB(requisterPojo);
						mav = new ModelAndView("PostedInHome");
					} else {
						mav = new ModelAndView("Error");
					}
				} else {
					mav = new ModelAndView("Home");
				}
			} catch (ApplicationException e) {
				LOGGER.error(e.getMessage());
				mav = new ModelAndView("Error");
				mav.addObject("message", e.getMessage());
			}
		} else {
			List<StatesPojo> allStates = usersService.getAllStates();
			List<BloodGroupPojo> allBloodGroups = usersService.getAllBloodGroups();
			List<HospitalPojo> allHospitals = recipientService.getAllHospitals();
			mav = new ModelAndView("PostBloodRequirement");
			mav.addObject("allHospitals", allHospitals);
			mav.addObject("allStates", allStates);
			mav.addObject("allBloodGroups", allBloodGroups);
		}
		return mav;
	}

	@RequestMapping(value = "/recipientRequests", method = RequestMethod.GET)

	public ModelAndView recipientRequests(@ModelAttribute("recipient") RecipientPojo recipientPojo,
			BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();

		HttpSession session = request.getSession(false);
		List<DonorPojo> details = new ArrayList<DonorPojo>();
		List<DonorPojo> compatibilityDetails = new ArrayList<DonorPojo>();

		try {
			if (session.getAttribute("username") != null) {
				details = recipientService.donorCheck(recipientPojo);
				compatibilityDetails = recipientService.donorCompatibilityCheck(recipientPojo);
				if (!details.isEmpty() || !compatibilityDetails.isEmpty()) {
					mav = new ModelAndView("DonorDetails");
					if (!details.isEmpty()) {
						mav.addObject("details", details);
					} else {
						mav.addObject("message", "No matched donors available.Please check with compatible donors");
					}

					if (!compatibilityDetails.isEmpty()) {
						mav.addObject("compatibilityDetails", compatibilityDetails);
					}

				}

				else {
					List<StatesPojo> allStates = usersService.getAllStates();
					List<BloodGroupPojo> allBloodGroups = usersService.getAllBloodGroups();
					mav = new ModelAndView("SearchDonor");
					mav.addObject("donornotfound", "No donor found.Click here to post your requirement");
					mav.addObject("allStates", allStates);
					mav.addObject("allBloodGroups", allBloodGroups);
				}
			} else {
				mav = new ModelAndView("Home");
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			mav = new ModelAndView("Error");
			mav.addObject("message", e.getMessage());
		}
		return mav;
	}

}
